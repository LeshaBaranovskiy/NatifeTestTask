package com.example.natifetesttask.presentation.navigation

import androidx.fragment.app.FragmentManager
import com.example.natifetesttask.presentation.fragment.SearchGifsFragment
import com.example.natifetesttask.presentation.fragment.SelectedGifFragment

object FragmentNavigation: Navigation() {
    const val TAG_SEARCH_GIFS_FRAGMENT = "TAG_SEARCH_GIFS_FRAGMENT"
    const val TAG_SELECTED_GIF_FRAGMENT = "TAG_SELECTED_GIF_FRAGMENT"

    fun navigateToSearchGifsFragment(
        fragmentManager: FragmentManager
    ) {
        navigateTo(
            fragmentManager,
            SearchGifsFragment.newInstance(),
            TAG_SEARCH_GIFS_FRAGMENT
        )
    }

    fun navigateToSelectedGiftFragment(
        fragmentManager: FragmentManager,
        offset: Int,
        text: String
    ) {
        navigateTo(
            fragmentManager,
            SelectedGifFragment.newInstance(offset, text),
            TAG_SELECTED_GIF_FRAGMENT
        )
    }
}