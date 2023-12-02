package com.pedroabreudev.core.data.repository

import androidx.paging.PagingSource
import com.pedroabreudev.core.domain.model.Character

interface CharacterRepository {

    fun getCharacters(query: String): PagingSource<Int, Character>
}