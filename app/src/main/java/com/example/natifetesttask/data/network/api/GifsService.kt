package com.example.natifetesttask.data.network.api

import com.example.natifetesttask.common.util.result.Result
import com.example.natifetesttask.data.dto.GifsEntityResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GifsService {
    @GET("search")
    suspend fun getGifs(
        @Query("q") query: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("api_key") apiKey: String
    ): Result<GifsEntityResponse>
}