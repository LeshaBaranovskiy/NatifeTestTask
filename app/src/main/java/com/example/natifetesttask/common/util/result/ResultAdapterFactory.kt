package com.example.natifetesttask.common.util.result

import com.example.natifetesttask.common.util.result.error.ErrorIdentifier
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import com.example.natifetesttask.common.util.result.error.ResultCall

class ResultAdapterFactory(private val errorIdentifier: ErrorIdentifier) :
    CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        val rawReturnType: Class<*> = getRawType(returnType)
        if (rawReturnType == Call::class.java) {
            if (returnType is ParameterizedType) {
                val callInnerType: Type = getParameterUpperBound(0, returnType)
                if (getRawType(callInnerType) == Result::class.java) {
                    // resultType is Call<Result<*>> | callInnerType is Result<*>
                    if (callInnerType is ParameterizedType) {
                        val resultInnerType = getParameterUpperBound(0, callInnerType)
                        return ResultCallAdapter<Any?>(resultInnerType, errorIdentifier)
                    }
                    return ResultCallAdapter<Nothing>(Nothing::class.java, errorIdentifier)
                }
            }
        }

        return null
    }
}

private class ResultCallAdapter<R>(
    private val type: Type,
    private val errorIdentifier: ErrorIdentifier
) : CallAdapter<R, Call<Result<R>>> {

    override fun responseType() = type

    override fun adapt(call: Call<R>): Call<Result<R>> = ResultCall(call, errorIdentifier)
}