package com.example.natifetesttask.common.util.result

import com.example.natifetesttask.common.util.result.error.CustomError
import com.example.natifetesttask.common.util.result.error.HttpException
import com.example.natifetesttask.common.util.result.error.IHttpResponse
import java.io.IOException
import java.net.SocketTimeoutException

sealed class Result<out T> {
    sealed class Success<T> : Result<T>() {
        abstract val value: T

        abstract val lastModified: String?

        override fun toString() = "Success($value)"

        data class HttpResponse<T>(
            override val value: T,
            override val statusCode: Int,
            override val statusMessage: String? = null,
            override val url: String? = null,
            override val errorBody: CustomError? = null,
            override val lastModified: String? = null
        ) : Success<T>(), IHttpResponse

        class Value<T>(override val value: T, override val lastModified: String? = null) : Success<T>()
    }

    sealed class Failure<E : Throwable>(
        open val error: E? = null
    ) : Result<Nothing>() {

        override fun toString() = "Failure($error)"

        class Error(override val error: Throwable) :
            Failure<Throwable>(error)

        class IoError(override val error: IOException) :
            Failure<IOException>(error)

        class HttpError(override val error: HttpException) :
            Failure<HttpException>(error), IHttpResponse {

            override val statusCode: Int get() = error.statusCode

            override val errorBody: CustomError?
                get() = error.errorBody

            override val statusMessage: String? get() = error.statusMessage

            override val url: String? get() = error.url
        }

        class TimeOutError(
            override val error: SocketTimeoutException
        ) : Failure<SocketTimeoutException>(error)
    }
}