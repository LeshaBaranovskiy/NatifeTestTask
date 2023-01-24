package com.example.natifetesttask.common.util.result

import com.example.natifetesttask.common.util.result.error.ErrorInfo

fun <T> Result<T>.isSuccess(): Boolean {
    return this is Result.Success
}

fun <T> Result<T>.asSuccess(): Result.Success<T> {
    return this as Result.Success<T>
}

fun <T> Result<T>.asFailure(): Result.Failure<*> {
    return this as Result.Failure<*>
}

fun Result.Failure<*>.getErrorInfo(): ErrorInfo {
    return when (this) {
        is Result.Failure.IoError -> ErrorInfo(message = "No connection!", exception = this.error)
        is Result.Failure.HttpError -> ErrorInfo(
            url = this.url,
            code = this.statusCode,
            message = this.statusMessage ?: "Bad request",
            customError = this.errorBody,
            exception = this.error
        )
        is Result.Failure.TimeOutError -> ErrorInfo(message = "Time out", exception = this.error)
        is Result.Failure.Error -> ErrorInfo(message = "No define", exception = this.error)
    }
}

fun <T, R> Result<T>.map(transform: (value: T) -> R): Result<R> {
    return when (this) {
        is Result.Success -> Result.Success.Value(transform(value))
        is Result.Failure<*> -> this
    }
}