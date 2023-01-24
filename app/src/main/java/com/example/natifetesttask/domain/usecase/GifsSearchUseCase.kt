package com.example.natifetesttask.domain.usecase

import com.example.natifetesttask.domain.model.entity.GifsEntity
import com.example.natifetesttask.domain.params.SearchParams
import com.example.natifetesttask.domain.repository.remote.GifsRepository
import com.example.natifetesttask.domain.usecase.base.BaseUseCase
import com.example.natifetesttask.common.util.result.Result

class GifsSearchUseCase(
    private val repository: GifsRepository
): BaseUseCase<GifsEntity, SearchParams>() {

    override suspend fun getSuspend(params: SearchParams): Result<GifsEntity> {
        return repository.getGifs(params.query, params.limit, params.offset)
    }
}