package com.example.natifetesttask.common.util.result.error

import com.example.natifetesttask.common.util.result.error.CustomError

interface IHttpResponse {
    val statusCode: Int?
    val statusMessage: String?
    val url: String?
    val errorBody: CustomError?
}