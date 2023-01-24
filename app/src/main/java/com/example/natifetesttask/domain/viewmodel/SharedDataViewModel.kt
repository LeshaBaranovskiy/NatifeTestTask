package com.example.natifetesttask.domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.natifetesttask.data.local.dbentity.DBBlackListEntity

class SharedDataViewModel: ViewModel() {
    private val _blackList = MutableLiveData<MutableList<DBBlackListEntity>>()
    val blackList: LiveData<MutableList<DBBlackListEntity>> = _blackList

    fun setBlackList(blackList: MutableList<DBBlackListEntity>) {
        _blackList.value = blackList
    }
}