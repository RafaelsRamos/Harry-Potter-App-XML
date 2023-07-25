package com.scookie.database.di

import android.content.Context
import androidx.room.Room
import com.scookie.database.dao.CharactersDao
import com.scookie.database.database.CharacterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideCharacterDatabase(@ApplicationContext context: Context): CharacterDatabase {

        return Room.databaseBuilder(
            context = context,
            klass = CharacterDatabase::class.java,
            name = "characters.db"
        ).build()

    }

    @Provides
    @Singleton
    fun provideCharacterDao(characterDatabase: CharacterDatabase): CharactersDao {
        return characterDatabase.dao
    }

}