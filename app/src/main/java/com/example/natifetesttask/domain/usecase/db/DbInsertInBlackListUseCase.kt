package com.example.natifetesttask.domain.usecase.db

import com.example.natifetesttask.data.local.dbentity.DBBlackListEntity
import com.example.natifetesttask.domain.repository.db.DbBlackListRepository
import com.example.natifetesttask.domain.usecase.base.BaseUseCaseDb
import javax.inject.Inject

class DbInsertInBlackListUseCase @Inject constructor(
    private val blackListRepository: DbBlackListRepository
): BaseUseCaseDb<Unit, DBBlackListEntity>() {
    override suspend fun getSuspend(params: DBBlackListEntity?) {
        return blackListRepository.insertGif(params!!)
    }
}