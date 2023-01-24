package com.example.natifetesttask.data.di

import android.content.Context
import com.example.natifetesttask.common.Application
import com.example.natifetesttask.data.local.AppDatabase
import com.example.natifetesttask.data.local.dao.BlackListDao
import com.example.natifetesttask.data.local.dao.LastQueriesDao
import com.example.natifetesttask.data.local.localdataprovider.LocalBlackListDataProvider
import com.example.natifetesttask.data.local.localdataprovider.LocalLastQueriesDataProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Singleton
    @Provides
    fun provideBlackListDao(appDatabase: AppDatabase): BlackListDao =
        appDatabase.getBlackListDao()

    @Singleton
    @Provides
    fun provideLastQueriesDao(appDatabase: AppDatabase): LastQueriesDao =
        appDatabase.getLastQueriesDao()

    @Singleton
    @Provides
    fun provideLocalBlackListDataProvider(
        blackListDao: BlackListDao
    ): LocalBlackListDataProvider =
        LocalBlackListDataProvider(blackListDao)

    @Singleton
    @Provides
    fun provideLocalLastQueriesDataProvider(
        lastQueriesDao: LastQueriesDao
    ): LocalLastQueriesDataProvider =
        LocalLastQueriesDataProvider(lastQueriesDao)

    @Singleton
    @Provides
    fun provideDBInstance(context: Context): AppDatabase =
        AppDatabase.getAppDataBase(context)

    @Singleton
    @Provides
    fun provideAppContext(application: Application): Context =
        application.applicationContext
}