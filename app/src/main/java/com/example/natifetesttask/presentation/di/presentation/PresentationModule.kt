package com.example.natifetesttask.presentation.di.presentation

import com.example.natifetesttask.presentation.di.presentation.provider.ActivityProvider
import com.example.natifetesttask.presentation.di.presentation.provider.FragmentProvider
import dagger.Module

@Module(
    includes = [
        ActivityProvider::class,
        FragmentProvider::class
    ]
)
class PresentationModule