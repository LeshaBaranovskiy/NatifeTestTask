package com.example.natifetesttask.data.network.source

import com.example.natifetesttask.common.util.result.ResultAdapterFactory
import com.example.natifetesttask.common.util.result.error.ErrorIdentifier
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource(
    private val gson: Gson,
    private val errorIdentifier: ErrorIdentifier
): RemoteDataSourceHelper {
    override fun <Api> buildApi(
        api: Class<Api>,
        url: String,
        isCache: Boolean,
    ): Api {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(ResultAdapterFactory(errorIdentifier))
            .build()
            .create(api)
    }
}