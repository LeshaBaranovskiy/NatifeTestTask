package com.example.natifetesttask.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
//    @Singleton
//    @Provides
//    fun provideWeatherDao(appDatabase: AppDatabase): WeatherDao =
//        appDatabase.getWeatherDao()
//
//    @Singleton
//    @Provides
//    fun provideFavouriteCitiesDao(appDatabase: AppDatabase): FavouriteCitiesDao =
//        appDatabase.getFavouriteCitiesDao()
//
//    @Singleton
//    @Provides
//    fun provideLocalWeatherDataProvider(
//        weatherDao: WeatherDao
//    ): LocalWeatherDataProvider =
//        LocalWeatherDataProvider(weatherDao)
//
//    @Singleton
//    @Provides
//    fun provideLocalFavouriteCitiesDataProvider(
//        favouriteCitiesDao: FavouriteCitiesDao
//    ): LocalFavouriteCitiesDataProvider =
//        LocalFavouriteCitiesDataProvider(favouriteCitiesDao)
//
//    @Singleton
//    @Provides
//    fun provideDBInstance(context: Context): AppDatabase =
//        AppDatabase.getAppDataBase(context)
//
//    @Singleton
//    @Provides
//    fun provideAppContext(application: Application): Context =
//        application.applicationContext
}