package com.example.natifetesttask.domain.repository.remote

import com.example.natifetesttask.common.util.result.Result
import com.example.natifetesttask.domain.model.entity.GifsEntity

interface GifsRepository {
    suspend fun getGifs(
        query: String,
        limit: Int,
        offset: Int
    ): Result<GifsEntity>
}