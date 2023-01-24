package com.example.natifetesttask.data.di

import com.example.natifetesttask.data.network.api.GifsDataProvider
import com.example.natifetesttask.data.network.api.GifsHelper
import com.example.natifetesttask.data.network.api.GifsService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataProviderModule {
    @Provides
    @Singleton
    fun provideGifsDataProvider(
        weatherService: GifsService
    ): GifsHelper = GifsDataProvider(weatherService)


}