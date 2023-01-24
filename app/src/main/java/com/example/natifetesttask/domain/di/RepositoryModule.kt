package com.example.natifetesttask.domain.di

import com.example.natifetesttask.data.local.localdataprovider.LocalBlackListDataProvider
import com.example.natifetesttask.data.local.localdataprovider.LocalLastQueriesDataProvider
import com.example.natifetesttask.data.network.api.GifsHelper
import com.example.natifetesttask.domain.mapper.GifsMapper
import com.example.natifetesttask.domain.repository.db.DbBlackListRepository
import com.example.natifetesttask.domain.repository.db.DbBlackListRepositoryImpl
import com.example.natifetesttask.domain.repository.db.DbLastQueriesRepository
import com.example.natifetesttask.domain.repository.db.DbLastQueriesRepositoryImpl
import com.example.natifetesttask.domain.repository.remote.GifsRepository
import com.example.natifetesttask.domain.repository.remote.GifsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideGifsRepository(
        gifsHelper: GifsHelper,
        gifsMapper: GifsMapper
    ): GifsRepository =
        GifsRepositoryImpl(
            gifsHelper, gifsMapper
        )

    @Singleton
    @Provides
    fun provideDbBlackListRepository(
        blackListDataProvider: LocalBlackListDataProvider
    ): DbBlackListRepository =
        DbBlackListRepositoryImpl(
            blackListDataProvider
        )

    @Singleton
    @Provides
    fun provideDbLastQueriesRepository(
        lastQueriesDataProvider: LocalLastQueriesDataProvider
    ): DbLastQueriesRepository =
        DbLastQueriesRepositoryImpl(
            lastQueriesDataProvider
        )
}