package com.example.natifetesttask.domain.usecase.db

import com.example.natifetesttask.data.local.dbentity.DBLastQueriesEntity
import com.example.natifetesttask.domain.repository.db.DbLastQueriesRepository
import com.example.natifetesttask.domain.usecase.base.BaseUseCaseDb
import javax.inject.Inject

class DbGetAllLastQueriesUseCase @Inject constructor(
    private val lastQueriesRepository: DbLastQueriesRepository
): BaseUseCaseDb<List<DBLastQueriesEntity>, Unit>() {
    override suspend fun getSuspend(params: Unit?): List<DBLastQueriesEntity> {
        return lastQueriesRepository.getAlQueries()
    }
}