package com.scookie.navigation.screens

sealed class Screen(val tag: String)

object CharacterListingScreen : Screen("CharacterListingScreen")
data class CharacterScreen(val id: String): Screen("CharacterScreen-$id")