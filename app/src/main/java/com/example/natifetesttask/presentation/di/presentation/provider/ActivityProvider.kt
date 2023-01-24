package com.example.natifetesttask.presentation.di.presentation.provider

import com.example.natifetesttask.presentation.acitivty.BaseActivity
import com.example.natifetesttask.presentation.acitivty.InitialActivity
import com.example.natifetesttask.presentation.acitivty.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityProvider {
    @ContributesAndroidInjector
    abstract fun provideSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun provideInitialActivity(): InitialActivity

    @ContributesAndroidInjector
    abstract fun provideBaseActivity(): BaseActivity
}