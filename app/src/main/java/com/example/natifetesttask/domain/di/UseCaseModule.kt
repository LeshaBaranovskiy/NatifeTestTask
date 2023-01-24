package com.example.natifetesttask.domain.di

import com.example.natifetesttask.domain.repository.GifsRepository
import com.example.natifetesttask.domain.usecase.GifsSearchUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideSearchGifsUseCase(
        weatherRepository: GifsRepository
    ): GifsSearchUseCase =
        GifsSearchUseCase(weatherRepository)
}