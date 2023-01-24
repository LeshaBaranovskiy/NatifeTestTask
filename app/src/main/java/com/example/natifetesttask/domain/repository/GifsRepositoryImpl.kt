package com.example.natifetesttask.domain.repository

import com.example.natifetesttask.common.util.result.Result
import com.example.natifetesttask.common.util.result.map
import com.example.natifetesttask.data.network.api.GifsHelper
import com.example.natifetesttask.domain.mapper.GifsMapper
import com.example.natifetesttask.domain.model.entity.GifsEntity
import javax.inject.Inject

class GifsRepositoryImpl @Inject constructor(
    private val gifsHelper: GifsHelper,
    private val gifsMapper: GifsMapper
): GifsRepository {
    override suspend fun getGifs(query: String, limit: Int, offset: Int): Result<GifsEntity> =
        gifsHelper.getGifs(query, limit, offset).map {
            gifsMapper.mapGifsResponseToEntity(it)
        }
}