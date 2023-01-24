package com.example.natifetesttask.domain.usecase.db

import com.example.natifetesttask.data.local.dbentity.DBLastQueriesEntity
import com.example.natifetesttask.domain.repository.db.DbBlackListRepository
import com.example.natifetesttask.domain.repository.db.DbLastQueriesRepository
import com.example.natifetesttask.domain.usecase.base.BaseUseCaseDb
import javax.inject.Inject

class DbInsertLastQueryUseCase @Inject constructor(
    private val lastQueriesRepository: DbLastQueriesRepository
): BaseUseCaseDb<Unit, DBLastQueriesEntity>() {
    override suspend fun getSuspend(params: DBLastQueriesEntity?) {
        return lastQueriesRepository.insertQuery(params!!)
    }
}