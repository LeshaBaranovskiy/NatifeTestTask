package com.example.natifetesttask.presentation.di

import com.example.natifetesttask.data.di.NetworkModule
import com.example.natifetesttask.presentation.di.presentation.PresentationModule
import dagger.Module

@Module(
    includes = [
        PresentationModule::class,
        NetworkModule::class
    ]
)
class ApplicationModule {
}