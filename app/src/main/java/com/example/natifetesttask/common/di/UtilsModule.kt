package com.example.natifetesttask.common.di

import com.example.natifetesttask.common.util.result.error.ErrorIdentifier
import dagger.Module
import dagger.Provides

@Module
class UtilsModule {
    @Provides
    fun provideErrorIdentifier(): ErrorIdentifier {
        return ErrorIdentifier()
    }
}