package com.example.natifetesttask.domain.repository.db

import com.example.natifetesttask.data.local.dbentity.DBLastQueriesEntity
import com.example.natifetesttask.data.local.localdataprovider.LocalLastQueriesDataProvider

class DbLastQueriesRepositoryImpl(
    private val dataProvider: LocalLastQueriesDataProvider
): DbLastQueriesRepository {
    override suspend fun getAlQueries(): List<DBLastQueriesEntity> =
        dataProvider.getAlQueries()

    override suspend fun deleteQueryByText(queryText: String) =
        dataProvider.deleteQueryByText(queryText)

    override suspend fun insertQuery(dbWeatherEntity: DBLastQueriesEntity) =
        dataProvider.insertQuery(dbWeatherEntity)

}