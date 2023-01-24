package com.example.natifetesttask.data.local.localdataprovider

import com.example.natifetesttask.data.local.dao.BlackListDao
import com.example.natifetesttask.data.local.dbentity.DBBlackListEntity

class LocalBlackListDataProvider(
    private val blackListDao: BlackListDao
) {
    suspend fun getAlBlackListGifs(): List<DBBlackListEntity> = blackListDao.getAlBlackListGifs()

    suspend fun deleteGifByGifId(gifId: Int) = blackListDao.deleteGifByGifId(gifId)

    suspend fun insertGif(dbWeatherEntity: DBBlackListEntity) = blackListDao.insertGif(dbWeatherEntity)
}