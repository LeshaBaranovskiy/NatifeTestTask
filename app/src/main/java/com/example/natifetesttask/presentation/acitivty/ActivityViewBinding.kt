package com.example.natifetesttask.presentation.acitivty

import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import androidx.viewbinding.ViewBinding

inline fun <reified T : ViewBinding> ComponentActivity.viewBinding(): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE) {
        val clazz: Class<T> = T::class.java
        val inflate = clazz.getMethod("inflate", LayoutInflater::class.java)
        val bindingObj = inflate.invoke(null, layoutInflater)
        bindingObj as T
    }