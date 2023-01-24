package com.example.natifetesttask.presentation.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.natifetesttask.R

open class Navigation {
    fun navigateTo(
        fragmentManager: FragmentManager,
        fragment: Fragment,
        tag: String
    ) {
        saveFragmentToBackStack(fragmentManager, fragment, tag, R.id.fragment_container)
    }

    private fun saveFragmentToBackStack(
        fragmentManager: FragmentManager,
        fragment: Fragment,
        tag: String,
        fragmentContainer: Int
    ) {
        fragmentManager
            .beginTransaction()
            .replace(fragmentContainer, fragment, tag)
            .addToBackStack(tag)
            .commit()
    }
}