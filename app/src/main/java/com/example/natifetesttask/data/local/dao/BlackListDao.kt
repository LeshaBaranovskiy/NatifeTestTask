package com.example.natifetesttask.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.natifetesttask.data.local.dbentity.DBBlackListEntity
import com.example.natifetesttask.data.local.dbentity.DBLastQueriesEntity

@Dao
interface BlackListDao {
    @Query("SELECT * FROM black_list")
    suspend fun getAlBlackListGifs(): List<DBBlackListEntity>

    @Query("DELETE FROM black_list WHERE gif_id = :gifId")
    suspend fun deleteGifByGifId(gifId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGif(dbWeatherEntity: DBBlackListEntity)
}