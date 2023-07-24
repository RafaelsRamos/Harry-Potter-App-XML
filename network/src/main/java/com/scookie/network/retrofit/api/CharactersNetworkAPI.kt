package com.scookie.network.retrofit.api

import com.scookie.network.models.CharacterDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CharactersNetworkAPI {

    @GET("characters")
    suspend fun getAllCharacters(): List<CharacterDTO>

    @GET("character/{characterId}")
    suspend fun getCharacter(@Path("characterId") id: String): List<CharacterDTO>

}