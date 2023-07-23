package com.scookie.data.repositories.characters

import com.scookie.domainmodel.Character
import com.scookie.network.models.toModel
import com.scookie.network.retrofit.CharactersNetwork
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val charactersNetwork: CharactersNetwork
): CharactersRepository {

    override suspend fun getAllCharacters(): List<Character> {

        return charactersNetwork
            .getAllCharacters()
            .map { characterDTO -> characterDTO.toModel() }

    }

}