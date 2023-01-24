package com.example.natifetesttask.domain.usecase.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.example.natifetesttask.domain.usecase.subscriber.UseCaseSubscriber
import com.example.natifetesttask.common.util.result.Result

abstract class BaseUseCase<Type, in Params> where Type : Any {
    fun getExecute(
        subscriber: UseCaseSubscriber<Type>,
        params: Params
    ): LiveData<Result<Type>> {
        return liveData(Dispatchers.IO) {
            subscriber.onStart()
            try {
                subscriber.onComplete()
                emit(getSuspend(params))
            } catch (exception: Exception) {
                subscriber.onError(exception)
            }
        }
    }

    abstract suspend fun getSuspend(params: Params): Result<Type>
}