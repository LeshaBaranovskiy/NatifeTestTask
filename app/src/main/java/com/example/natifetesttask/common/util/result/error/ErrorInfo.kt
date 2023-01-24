package com.example.natifetesttask.common.util.result.error

import com.example.natifetesttask.common.util.result.error.CustomError

data class ErrorInfo(
    val code: Int? = null,
    val message: String,
    val customError: CustomError? = null,
    val url: String? = null,
    val exception: Throwable
)