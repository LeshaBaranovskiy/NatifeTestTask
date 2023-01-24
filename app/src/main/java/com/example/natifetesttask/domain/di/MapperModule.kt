package com.example.natifetesttask.domain.di

import com.example.natifetesttask.domain.mapper.GifsMapper
import com.example.natifetesttask.domain.mapper.GifsMapperImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MapperModule {
    @Provides
    @Singleton
    fun providesGifsMapper(): GifsMapper = GifsMapperImpl()
}