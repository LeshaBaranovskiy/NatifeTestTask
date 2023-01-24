package com.example.natifetesttask.domain.repository.db

import com.example.natifetesttask.data.local.dbentity.DBBlackListEntity
import com.example.natifetesttask.data.local.dbentity.DBLastQueriesEntity

interface DbBlackListRepository {
    suspend fun getAlBlackListGifs(): List<DBBlackListEntity>

    suspend fun deleteGifByGifId(gifId: Int)

    suspend fun insertGif(dbWeatherEntity: DBBlackListEntity)

}