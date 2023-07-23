package com.scookie.data.di

import com.scookie.data.repositories.characters.CharactersRepository
import com.scookie.data.repositories.characters.CharactersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    internal abstract fun bindCharactersRepository(repository: CharactersRepositoryImpl): CharactersRepository

}