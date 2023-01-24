package com.example.natifetesttask.data.local.localdataprovider

import com.example.natifetesttask.data.local.dao.LastQueriesDao
import com.example.natifetesttask.data.local.dbentity.DBLastQueriesEntity

class LocalLastQueriesDataProvider(
    private val lastQueriesDao: LastQueriesDao
) {
    suspend fun getAlQueries(): List<DBLastQueriesEntity> = lastQueriesDao.getAlQueries()

    suspend fun deleteQueryByText(queryText: String) = lastQueriesDao.deleteQueryByText(queryText)

    suspend fun insertQuery(dbWeatherEntity: DBLastQueriesEntity) = lastQueriesDao.insertQuery(dbWeatherEntity)
}