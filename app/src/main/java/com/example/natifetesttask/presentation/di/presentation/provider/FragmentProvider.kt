package com.example.natifetesttask.presentation.di.presentation.provider

import com.example.natifetesttask.presentation.fragment.BaseFragment
import com.example.natifetesttask.presentation.fragment.SearchGifsFragment
import com.example.natifetesttask.presentation.fragment.SelectedGifFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentProvider {
    @ContributesAndroidInjector
    abstract fun provideBaseFragment(): BaseFragment

    @ContributesAndroidInjector
    abstract fun provideSearchGifsFragment(): SearchGifsFragment

    @ContributesAndroidInjector
    abstract fun provideSelectedGifFragment(): SelectedGifFragment
}