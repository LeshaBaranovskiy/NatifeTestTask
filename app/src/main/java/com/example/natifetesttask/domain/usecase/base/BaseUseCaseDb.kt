package com.example.natifetesttask.domain.usecase.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.natifetesttask.domain.usecase.subscriber.UseCaseSubscriber

abstract class BaseUseCaseDb<Type, in Params> where Type : Any {
    fun getExecute(
        subscriber: UseCaseSubscriber<Type>,
        params: Params? = null
    ): LiveData<Type> {
        return liveData {
            subscriber.onStart()
            try {
                subscriber.onComplete()
                emit(getSuspend(params))
            } catch (exception: Exception) {
                subscriber.onError(exception)
            }
        }
    }

    abstract suspend fun getSuspend(params: Params? = null): Type
}