package com.example.natifetesttask.data.di

import com.example.natifetesttask.common.util.Constants
import com.example.natifetesttask.data.network.api.GifsService
import com.example.natifetesttask.data.network.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideGifsService(remoteDataSource: RemoteDataSource): GifsService =
        remoteDataSource.buildApi(
            GifsService::class.java,
            Constants.API_SERVICE_URL
        )
}