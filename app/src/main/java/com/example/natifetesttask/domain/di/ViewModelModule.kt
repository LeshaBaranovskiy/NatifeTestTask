package com.example.natifetesttask.domain.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.natifetesttask.domain.viewmodel.DbBlackListViewModel
import com.example.natifetesttask.domain.viewmodel.DbLastQueriesViewModel
import com.example.natifetesttask.domain.viewmodel.GifsViewModel
import com.example.natifetesttask.domain.viewmodel.base.ViewModelFactory
import com.example.natifetesttask.domain.viewmodel.base.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap as IntoMap1

@Module
interface ViewModelModule {
    @Binds
    fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap1
    @ViewModelKey(GifsViewModel::class)
    fun bindShowForecastViewModel(viewModel: GifsViewModel): ViewModel

    @Binds
    @IntoMap1
    @ViewModelKey(DbLastQueriesViewModel::class)
    fun bindDbLastQueriesViewModel(viewModel: DbLastQueriesViewModel): ViewModel

    @Binds
    @IntoMap1
    @ViewModelKey(DbBlackListViewModel::class)
    fun bindDbBlackListViewModel(viewModel: DbBlackListViewModel): ViewModel

}