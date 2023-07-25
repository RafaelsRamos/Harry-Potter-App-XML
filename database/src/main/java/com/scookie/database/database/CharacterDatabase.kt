package com.scookie.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.scookie.database.converters.ListStringConverter
import com.scookie.database.dao.CharactersDao
import com.scookie.database.models.CharacterEntity

@TypeConverters(ListStringConverter::class)
@Database(
    entities = [CharacterEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CharacterDatabase: RoomDatabase() {

    abstract val dao: CharactersDao

}