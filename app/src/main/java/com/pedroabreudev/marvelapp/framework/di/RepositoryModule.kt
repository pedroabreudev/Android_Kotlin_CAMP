package com.pedroabreudev.marvelapp.framework.di

import com.pedroabreudev.core.data.repository.CharacterRepository
import com.pedroabreudev.core.data.repository.CharactersRemoteDataSource
import com.pedroabreudev.marvelapp.framework.CharactersRepositoryImpl
import com.pedroabreudev.marvelapp.framework.network.response.DataWrapperResponse
import com.pedroabreudev.marvelapp.framework.remote.RetrofitCharactersDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindCharacterRepository(
        repository: CharactersRepositoryImpl
    ): CharacterRepository

    @Binds
    fun bindRemoteDataSource(
        dataSource: RetrofitCharactersDataSource
    ): CharactersRemoteDataSource<DataWrapperResponse>
}