package com.example.natifetesttask.common

import com.example.natifetesttask.common.di.AppComponent
import com.example.natifetesttask.common.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector

class Application : DaggerApplication(), HasAndroidInjector {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val applicationComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
        applicationComponent.inject(this)

        appComponent = applicationComponent
        return applicationComponent
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}