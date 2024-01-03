package com.pedroabreudev.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pedroabreudev.core.data.repository.CharacterRepository
import com.pedroabreudev.core.domain.model.Character
import com.pedroabreudev.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) : PagingUseCase<GetCharactersUseCase.GetCharactersParams, Character>() {
    override fun createFlowObservable(params: GetCharactersParams): Flow<PagingData<Character>> {
        return Pager(config = params.pagingConfig) {
            // PagingSource
            characterRepository.getCharacters(params.query)
        }.flow
    }

    data class GetCharactersParams(val query: String, val pagingConfig: PagingConfig)
}