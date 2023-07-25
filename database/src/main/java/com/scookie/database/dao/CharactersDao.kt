package com.scookie.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.scookie.database.models.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharactersDao {

    @Upsert
    suspend fun insertCharacter(characterEntity: CharacterEntity)

    @Upsert
    suspend fun insertCharacters(characterEntity: List<CharacterEntity>)

    @Delete
    suspend fun deleteCharacter(characterEntity: CharacterEntity)

    @Query("SELECT * FROM characterentity")
    fun getCharacters(): Flow<List<CharacterEntity>>

    @Query("SELECT * FROM characterentity WHERE id=:id")
    fun getCharacter(id: String): Flow<CharacterEntity>

    @Query("SELECT EXISTS(SELECT * FROM characterentity)")
    fun hasCharacters() : Boolean

    @Query("SELECT EXISTS(SELECT * FROM characterentity WHERE id = :id)")
    fun hasCharacter(id: String) : Boolean

}