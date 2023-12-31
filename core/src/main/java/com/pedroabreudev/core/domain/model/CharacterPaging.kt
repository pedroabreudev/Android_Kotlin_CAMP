package com.pedroabreudev.core.domain.model

data class CharacterPaging(
    val offset: Int,
    val total: Int,
    val characters: List<Character>
)