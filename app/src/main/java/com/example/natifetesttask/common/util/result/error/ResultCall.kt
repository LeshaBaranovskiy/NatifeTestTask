package com.example.natifetesttask.common.util.result.error

import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import com.google.gson.Gson
import java.lang.Exception
import java.net.SocketTimeoutException
import com.example.natifetesttask.common.util.result.Result

class ResultCall<T>(
    proxy: Call<T>,
    private val errorIdentifier: ErrorIdentifier
) : CallDelegate<T, Result<T>>(proxy) {

    override fun enqueueImpl(callback: Callback<Result<T>>) {
        proxy.enqueue(ResultCallback(this, callback, errorIdentifier))
    }

    override fun cloneImpl(): ResultCall<T> = ResultCall(proxy.clone(), errorIdentifier)

    class ResultCallback<T>(
        private val proxy: ResultCall<T>,
        private val callback: Callback<Result<T>>,
        private val errorIdentifier: ErrorIdentifier
    ) : Callback<T> {

        override fun onResponse(call: Call<T>, response: Response<T>) {
            val result: Result<T>
            if (response.isSuccessful) {
                result = Result.Success.HttpResponse(
                    value = response.body() as T,
                    statusCode = response.code(),
                    statusMessage = response.message(),
                    url = call.request().url.toString(),
                    lastModified = response.headers()["last-modified"]
                )
            } else {
                result = Result.Failure.HttpError(
                    HttpException(
                        statusCode = response.code(),
                        statusMessage = response.message(),
                        url = call.request().url.toString(),
                        errorBody = getCustomError(response.errorBody()?.string())
                    )
                )
                errorIdentifier.catchError(result)
            }


            callback.onResponse(proxy, Response.success(result))
        }

        override fun onFailure(call: Call<T>, error: Throwable) {
            val result = when (error) {
                is retrofit2.HttpException -> {
                    Result.Failure.HttpError(
                        HttpException(
                            error.code(),
                            error.message(),
                            cause = error,
                            errorBody = getCustomError(error.response()?.errorBody()?.string())
                        )
                    )
                }
                is IOException -> Result.Failure.IoError(error)
                is SocketTimeoutException -> Result.Failure.TimeOutError(error)
                else -> Result.Failure.Error(error)
            }

            errorIdentifier.catchError(result)
            callback.onResponse(proxy, Response.success(result))
        }


        private fun getCustomError(body: String?): CustomError? {
            return try {
                Gson().fromJson(body, CustomError::class.java)
            } catch (exc: Exception) {
                null
            }
        }

    }

    override fun timeout(): Timeout {
        return proxy.timeout()
    }
}