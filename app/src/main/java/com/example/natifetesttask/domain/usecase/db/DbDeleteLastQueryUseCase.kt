package com.example.natifetesttask.domain.usecase.db

import com.example.natifetesttask.domain.repository.db.DbLastQueriesRepository
import com.example.natifetesttask.domain.usecase.base.BaseUseCaseDb
import javax.inject.Inject

class DbDeleteLastQueryUseCase @Inject constructor(
    private val lastQueriesRepository: DbLastQueriesRepository
): BaseUseCaseDb<Unit, String>() {
    override suspend fun getSuspend(params: String?) {
        return lastQueriesRepository.deleteQueryByText(params.toString())
    }
}