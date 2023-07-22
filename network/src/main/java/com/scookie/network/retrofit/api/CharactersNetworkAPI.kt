package com.scookie.network.retrofit.api

import com.scookie.network.models.CharacterDTO
import retrofit2.http.GET

interface CharactersNetworkAPI {

    @GET("characters")
    suspend fun getAllCharacters(): List<CharacterDTO>

}