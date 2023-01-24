package com.example.natifetesttask.common.util.result.error

import android.util.Log
import com.example.natifetesttask.common.util.result.Result
import com.example.natifetesttask.common.util.result.asFailure
import com.example.natifetesttask.common.util.result.isSuccess

class ErrorIdentifier {
    fun catchError(message: Result<Any>) {
        if (message.isSuccess()) return

        when (message.asFailure()) {
            is Result.Failure.HttpError -> message.asFailure().logIt()
            is Result.Failure.Error -> message.asFailure().logIt()
            is Result.Failure.TimeOutError -> message.asFailure().logIt()
            is Result.Failure.IoError -> message.asFailure().logIt()
        }
    }

    private fun Result.Failure<*>.logIt() {
        Log.d("error", "Error message: ${error?.message}")
    }
}