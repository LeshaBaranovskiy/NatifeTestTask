package com.example.natifetesttask.domain.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.natifetesttask.domain.model.entity.GifsEntity
import com.example.natifetesttask.domain.params.SearchParams
import com.example.natifetesttask.domain.usecase.GifsSearchUseCase
import com.example.natifetesttask.domain.usecase.subscriber.UseCaseSubscriberImpl
import com.example.natifetesttask.common.util.result.Result
import javax.inject.Inject

class GifsViewModel @Inject constructor(
    private val gifsSearchUseCase: GifsSearchUseCase
): ViewModel() {

    fun gifsSearch(searchParams: SearchParams): LiveData<Result<GifsEntity>> {
        return gifsSearchUseCase.getExecute(UseCaseSubscriberImpl(
            {
                Log.d("GIFS_SEARCH", "gifsSearch $it")
            },
            {
                Log.d("GIFS_SEARCH", "gifsSearch: ${it.message}", it as Exception)
            },
            {
                Log.d("GIFS_SEARCH", "gifsSearch")
            }
        ), searchParams)
    }
}