package com.example.natifetesttask.domain.usecase.db

import com.example.natifetesttask.domain.repository.db.DbBlackListRepository
import com.example.natifetesttask.domain.usecase.base.BaseUseCaseDb
import javax.inject.Inject

class DbDeleteFromBlackListUseCase @Inject constructor(
    private val blackListRepository: DbBlackListRepository
): BaseUseCaseDb<Unit, Int>() {
    override suspend fun getSuspend(params: Int?) {
        return blackListRepository.deleteGifByGifId(params ?: 0)
    }
}