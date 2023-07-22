package com.scookie.network.retrofit

import com.scookie.network.APIClient
import com.scookie.network.models.CharacterDTO
import com.scookie.network.retrofit.api.CharactersNetworkAPI

class CharactersNetworkImpl: CharactersNetwork {

    private val charactersAPI = APIClient.hpRetrofit.create(CharactersNetworkAPI::class.java)

    override suspend fun getAllCharacters(): List<CharacterDTO> {
        return charactersAPI.getAllCharacters()
    }

}