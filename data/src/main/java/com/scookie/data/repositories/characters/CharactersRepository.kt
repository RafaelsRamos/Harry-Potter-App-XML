package com.scookie.data.repositories.characters

import com.scookie.domainmodel.Character

interface CharactersRepository {

    suspend fun getAllCharacters(): List<Character>

}