package com.pedroabreudev.marvelapp.framework.remote

import com.pedroabreudev.core.data.repository.CharactersRemoteDataSource
import com.pedroabreudev.marvelapp.framework.network.MarvelApi
import com.pedroabreudev.marvelapp.framework.network.response.DataWrapperResponse
import javax.inject.Inject

class RetrofitCharactersDataSource @Inject constructor(
    private val marvelApi: MarvelApi
) : CharactersRemoteDataSource<DataWrapperResponse> {
    override suspend fun fetchCharacters(queries: Map<String, String>): DataWrapperResponse {
        return marvelApi.getCharacters(queries)
    }
}