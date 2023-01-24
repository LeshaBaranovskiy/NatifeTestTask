package com.example.natifetesttask.data.network.api

import com.example.natifetesttask.common.util.Constants
import com.example.natifetesttask.common.util.result.Result
import com.example.natifetesttask.data.dto.GifsEntityResponse
import javax.inject.Inject

class GifsDataProvider @Inject constructor(
    private val weatherService: GifsService
): GifsHelper {
    override suspend fun getGifs(
        query: String,
        limit: Int,
        offset: Int
    ): Result<GifsEntityResponse> =
        weatherService.getGifs(query, limit, offset, Constants.API_KEY)
}