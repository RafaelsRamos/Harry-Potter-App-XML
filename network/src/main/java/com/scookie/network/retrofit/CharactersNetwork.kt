package com.scookie.network.retrofit

import com.scookie.network.models.CharacterDTO

interface CharactersNetwork {

    suspend fun getAllCharacters(): List<CharacterDTO>

}