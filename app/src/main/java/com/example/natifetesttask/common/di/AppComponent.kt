package com.example.natifetesttask.common.di

import com.example.natifetesttask.common.Application
import com.example.natifetesttask.domain.di.DomainModule
import com.example.natifetesttask.domain.di.ViewModelModule
import com.example.natifetesttask.presentation.di.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        DomainModule::class,
        ViewModelModule::class,
        UtilsModule::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}