package com.pedroabreudev.marvelapp.framework.network.response

data class DataContainerResponse(
    val offset: Int,
    val totalL: Int,
    val results: List<CharacterResponse>
)
