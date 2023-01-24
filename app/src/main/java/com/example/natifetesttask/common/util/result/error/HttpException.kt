package com.example.natifetesttask.common.util.result.error

import com.example.natifetesttask.common.util.result.error.CustomError

class HttpException(
    val statusCode: Int,
    val statusMessage: String? = null,
    val url: String? = null,
    val errorBody: CustomError? = null,
    cause: Throwable? = null
) : Exception(null, cause)