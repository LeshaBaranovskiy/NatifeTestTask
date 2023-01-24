package com.example.natifetesttask.domain.di

import com.example.natifetesttask.domain.repository.db.DbBlackListRepository
import com.example.natifetesttask.domain.repository.db.DbLastQueriesRepository
import com.example.natifetesttask.domain.repository.remote.GifsRepository
import com.example.natifetesttask.domain.usecase.GifsSearchUseCase
import com.example.natifetesttask.domain.usecase.db.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideSearchGifsUseCase(
        gifsRepository: GifsRepository
    ): GifsSearchUseCase =
        GifsSearchUseCase(gifsRepository)

    @Provides
    @Singleton
    fun provideDbDeleteFromBlackListUseCase(
        blackListRepository: DbBlackListRepository
    ): DbDeleteFromBlackListUseCase =
        DbDeleteFromBlackListUseCase(blackListRepository)

    @Provides
    @Singleton
    fun provideDbGetAllBlackListGifsUseCase(
        blackListRepository: DbBlackListRepository
    ): DbGetAllBlackListGifsUseCase =
        DbGetAllBlackListGifsUseCase(blackListRepository)

    @Provides
    @Singleton
    fun provideDbInsertInBlackListUseCase(
        blackListRepository: DbBlackListRepository
    ): DbInsertInBlackListUseCase =
        DbInsertInBlackListUseCase(blackListRepository)

    @Provides
    @Singleton
    fun provideDbDeleteLastQueryUseCase(
        lastQueriesRepository: DbLastQueriesRepository
    ): DbDeleteLastQueryUseCase =
        DbDeleteLastQueryUseCase(lastQueriesRepository)

    @Provides
    @Singleton
    fun provideDbInsertLastQueryUseCase(
        lastQueriesRepository: DbLastQueriesRepository
    ): DbInsertLastQueryUseCase =
        DbInsertLastQueryUseCase(lastQueriesRepository)

    @Provides
    @Singleton
    fun provideDbGetAllLastQueriesUseCase(
        lastQueriesRepository: DbLastQueriesRepository
    ): DbGetAllLastQueriesUseCase =
        DbGetAllLastQueriesUseCase(lastQueriesRepository)
}