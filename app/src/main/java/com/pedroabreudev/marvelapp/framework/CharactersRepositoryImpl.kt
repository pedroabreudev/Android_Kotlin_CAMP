package com.pedroabreudev.marvelapp.framework

import androidx.paging.PagingSource
import com.pedroabreudev.core.data.repository.CharacterRepository
import com.pedroabreudev.core.data.repository.CharactersRemoteDataSource
import com.pedroabreudev.core.domain.model.Character
import com.pedroabreudev.marvelapp.framework.network.response.DataWrapperResponse
import com.pedroabreudev.marvelapp.framework.paging.CharactersPagingSource
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val remoteDataSource: CharactersRemoteDataSource<DataWrapperResponse>
) : CharacterRepository {
    override fun getCharacters(query: String): PagingSource<Int, Character> {
        return CharactersPagingSource(remoteDataSource, query)
    }
}