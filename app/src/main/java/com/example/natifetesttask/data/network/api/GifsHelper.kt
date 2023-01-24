package com.example.natifetesttask.data.network.api

import com.example.natifetesttask.common.util.result.Result
import com.example.natifetesttask.data.dto.GifsEntityResponse

interface GifsHelper {
    suspend fun getGifs(
        query: String,
        limit: Int,
        offset: Int
    ): Result<GifsEntityResponse>
}