package com.example.natifetesttask.domain.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.natifetesttask.data.local.dbentity.DBBlackListEntity
import com.example.natifetesttask.domain.usecase.db.DbDeleteFromBlackListUseCase
import com.example.natifetesttask.domain.usecase.db.DbDeleteLastQueryUseCase
import com.example.natifetesttask.domain.usecase.db.DbGetAllBlackListGifsUseCase
import com.example.natifetesttask.domain.usecase.db.DbInsertInBlackListUseCase
import com.example.natifetesttask.domain.usecase.subscriber.UseCaseSubscriber
import com.example.natifetesttask.domain.usecase.subscriber.UseCaseSubscriberImpl
import javax.inject.Inject

class DbBlackListViewModel @Inject constructor(
    private val dbGetAllBlackListGifsUseCase: DbGetAllBlackListGifsUseCase,
    private val dbInsertInBlackListUseCase: DbInsertInBlackListUseCase,
    private val dbDeleteFromBlackListUseCase: DbDeleteFromBlackListUseCase
): ViewModel() {

    fun getAllBlackListGifs(): LiveData<List<DBBlackListEntity>> {
        return dbGetAllBlackListGifsUseCase.getExecute(UseCaseSubscriberImpl(
        {
            Log.d("getAllBlackListGifs", "getAllBlackListGifs $it")
        },
        {
            Log.d("getAllBlackListGifs", "getAllBlackListGifs: ${it.message}", it as Exception)
        },
        {
            Log.d("getAllBlackListGifs", "getAllBlackListGifs Canceled")
        }))
    }

    fun insertInBlackList(dbBlackListEntity: DBBlackListEntity): LiveData<Unit> {
        return dbInsertInBlackListUseCase.getExecute(UseCaseSubscriberImpl(
            {
                Log.d("dbBlackListEntity", "dbBlackListEntity $it")
            },
            {
                Log.d("dbBlackListEntity", "dbBlackListEntity: ${it.message}", it as Exception)
            },
            {
                Log.d("dbBlackListEntity", "dbBlackListEntity Canceled")
            }), dbBlackListEntity)
    }

    fun deleteFromBlackList(gifId: Int): LiveData<Unit> {
        return dbDeleteFromBlackListUseCase.getExecute(UseCaseSubscriberImpl(
            {
                Log.d("dbBlackListEntity", "dbBlackListEntity $it")
            },
            {
                Log.d("dbBlackListEntity", "dbBlackListEntity: ${it.message}", it as Exception)
            },
            {
                Log.d("dbBlackListEntity", "dbBlackListEntity Canceled")
            }), gifId)
    }
}