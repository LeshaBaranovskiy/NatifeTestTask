package com.example.natifetesttask.presentation.fragment

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle.State.DESTROYED
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> viewBinding() =
    FragmentViewBindingDelegate(T::class.java)

class FragmentViewBindingDelegate<T : ViewBinding>(
    private val bindingClass: Class<T>
) : ReadOnlyProperty<Fragment, T> {

    private var binding: T? = null

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T = binding ?: bind(thisRef)

    private fun bind(fragment: Fragment): T {
        val exc = IllegalStateException(
            "Don't access viewBinding before on ViewCreated() or after onDestroyView() inclusive"
        )
        val view = fragment.view ?: throw exc
        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (lifecycle.currentState == DESTROYED) throw exc

        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onDestroy(owner: LifecycleOwner) {
                binding = null
            }
        })

        val bindMethod = bindingClass.getMethod("bind", View::class.java)
        val newBinding = bindMethod.invoke(null, view) as T
        binding = newBinding
        return newBinding
    }
}