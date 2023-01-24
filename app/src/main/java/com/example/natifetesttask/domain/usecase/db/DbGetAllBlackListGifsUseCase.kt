package com.example.natifetesttask.domain.usecase.db

import com.example.natifetesttask.data.local.dbentity.DBBlackListEntity
import com.example.natifetesttask.domain.repository.db.DbBlackListRepository
import com.example.natifetesttask.domain.usecase.base.BaseUseCaseDb
import javax.inject.Inject

class DbGetAllBlackListGifsUseCase @Inject constructor(
    private val blackListRepository: DbBlackListRepository
): BaseUseCaseDb<List<DBBlackListEntity>, Unit>() {
    override suspend fun getSuspend(params: Unit?): List<DBBlackListEntity> {
        return blackListRepository.getAlBlackListGifs()
    }
}