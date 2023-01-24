package com.example.natifetesttask.domain.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.natifetesttask.data.local.dbentity.DBLastQueriesEntity
import com.example.natifetesttask.domain.usecase.db.DbDeleteLastQueryUseCase
import com.example.natifetesttask.domain.usecase.db.DbGetAllLastQueriesUseCase
import com.example.natifetesttask.domain.usecase.db.DbInsertLastQueryUseCase
import com.example.natifetesttask.domain.usecase.subscriber.UseCaseSubscriberImpl
import javax.inject.Inject

class DbLastQueriesViewModel @Inject constructor(
    private val dbGetAllLastQueriesUseCase: DbGetAllLastQueriesUseCase,
    private val dbInsertLastQueryUseCase: DbInsertLastQueryUseCase,
    private val dbDeleteLastQueryUseCase: DbDeleteLastQueryUseCase,
): ViewModel() {
    fun getAllLastQueries(): LiveData<List<DBLastQueriesEntity>> {
        return dbGetAllLastQueriesUseCase.getExecute(
            UseCaseSubscriberImpl(
            {
                Log.d("getAllLastQueries", "getAllLastQueries $it")
            },
            {
                Log.d("getAllLastQueries", "getAllLastQueries: ${it.message}", it as Exception)
            },
            {
                Log.d("getAllLastQueries", "getAllLastQueries Canceled")
            })
        )
    }

    fun insertInBlackList(dBLastQueriesEntity: DBLastQueriesEntity): LiveData<Unit> {
        return dbInsertLastQueryUseCase.getExecute(UseCaseSubscriberImpl(
            {
                Log.d("insertInBlackList", "insertInBlackList $it")
            },
            {
                Log.d("insertInBlackList", "insertInBlackList: ${it.message}", it as Exception)
            },
            {
                Log.d("insertInBlackList", "insertInBlackList Canceled")
            }), dBLastQueriesEntity)
    }

    fun deleteFromBlackList(text: String): LiveData<Unit> {
        return dbDeleteLastQueryUseCase.getExecute(UseCaseSubscriberImpl(
            {
                Log.d("deleteFromBlackList", "deleteFromBlackList $it")
            },
            {
                Log.d("deleteFromBlackList", "deleteFromBlackList: ${it.message}", it as Exception)
            },
            {
                Log.d("deleteFromBlackList", "deleteFromBlackList Canceled")
            }), text)
    }
}