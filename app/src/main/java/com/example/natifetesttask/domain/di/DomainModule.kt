package com.example.natifetesttask.domain.di

import dagger.Module

@Module(
    includes = [
        MapperModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        ViewModelModule::class
    ]
)
class DomainModule {
}