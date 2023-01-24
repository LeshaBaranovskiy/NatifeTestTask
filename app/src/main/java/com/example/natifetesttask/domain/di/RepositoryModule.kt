package com.example.natifetesttask.domain.di

import com.example.natifetesttask.data.network.api.GifsHelper
import com.example.natifetesttask.domain.mapper.GifsMapper
import com.example.natifetesttask.domain.repository.GifsRepository
import com.example.natifetesttask.domain.repository.GifsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideGifsRepository(
        weatherHelper: GifsHelper,
        weatherMapper: GifsMapper
    ): GifsRepository =
        GifsRepositoryImpl(
            weatherHelper, weatherMapper
        )
}