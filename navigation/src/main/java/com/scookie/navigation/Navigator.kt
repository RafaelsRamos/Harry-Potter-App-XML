package com.scookie.navigation

import com.scookie.navigation.screens.Screen

interface Navigator {

    fun navigateTo(screen: Screen)

    fun goBack()

}