package com.example.natifetesttask.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.natifetesttask.data.local.dbentity.DBLastQueriesEntity

@Dao
interface LastQueriesDao {
    @Query("SELECT * FROM last_queries")
    suspend fun getAlQueries(): List<DBLastQueriesEntity>

    @Query("DELETE FROM last_queries WHERE query_text = :queryText")
    suspend fun deleteQueryByText(queryText: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuery(dbWeatherEntity: DBLastQueriesEntity)
}