package com.scookie.data.repositories.characters

import com.scookie.database.dao.CharactersDao
import com.scookie.database.models.toEntity
import com.scookie.database.models.toModel
import com.scookie.domainmodel.Character
import com.scookie.network.models.toModel
import com.scookie.network.retrofit.CharactersNetwork
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val charactersNetwork: CharactersNetwork,
    private val charactersDao: CharactersDao
): CharactersRepository {

    override suspend fun getAllCharacters(): List<Character> {

        return if (charactersDao.hasCharacters()) {
            charactersDao
                .getCharacters()
                .first()
                .toModel()
        } else {
            charactersNetwork
                .getAllCharacters()
                .toModel()
                .also { characters -> charactersDao.insertCharacters(characters.toEntity()) }
        }

    }

    override suspend fun getCharacter(id: String): Character {

        return if (charactersDao.hasCharacter(id)) {
            charactersDao
                .getCharacter(id)
                .first()
                .toModel()
        } else {
            charactersNetwork
                .getCharacter(id)
                .first()
                .toModel()
                .also { character -> charactersDao.insertCharacter(character.toEntity()) }
        }

    }

}