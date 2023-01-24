package com.example.natifetesttask.domain.repository.db

import com.example.natifetesttask.data.local.dbentity.DBBlackListEntity
import com.example.natifetesttask.data.local.dbentity.DBLastQueriesEntity
import com.example.natifetesttask.data.local.localdataprovider.LocalBlackListDataProvider
import javax.inject.Inject

class DbBlackListRepositoryImpl @Inject constructor(
    private val localBlackListDataProvider: LocalBlackListDataProvider
): DbBlackListRepository {
    override suspend fun getAlBlackListGifs(): List<DBBlackListEntity> =
        localBlackListDataProvider.getAlBlackListGifs()

    override suspend fun deleteGifByGifId(gifId: Int) =
        localBlackListDataProvider.deleteGifByGifId(gifId)

    override suspend fun insertGif(dbBlackListEntity: DBBlackListEntity) =
        localBlackListDataProvider.insertGif(dbBlackListEntity)
}