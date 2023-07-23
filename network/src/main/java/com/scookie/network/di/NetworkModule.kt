package com.scookie.network.di

import com.scookie.network.retrofit.CharactersNetwork
import com.scookie.network.retrofit.CharactersNetworkImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    @Singleton
    internal abstract fun bindCharactersNetwork(network: CharactersNetworkImpl): CharactersNetwork

}