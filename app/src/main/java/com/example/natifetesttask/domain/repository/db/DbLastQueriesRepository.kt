package com.example.natifetesttask.domain.repository.db

import com.example.natifetesttask.data.local.dbentity.DBLastQueriesEntity

interface DbLastQueriesRepository {
    suspend fun getAlQueries(): List<DBLastQueriesEntity>

    suspend fun deleteQueryByText(queryText: String)

    suspend fun insertQuery(dbWeatherEntity: DBLastQueriesEntity)
}