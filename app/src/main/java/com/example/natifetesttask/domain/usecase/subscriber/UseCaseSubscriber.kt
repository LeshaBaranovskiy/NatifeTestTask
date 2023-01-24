package com.example.natifetesttask.domain.usecase.subscriber

interface UseCaseSubscriber<T> {

    val next: (T) -> Unit
    val error: (Throwable) -> Unit
    val cancel: () -> Unit

    fun onStart()

    fun onError(throwable: Throwable)

    fun onComplete()
}