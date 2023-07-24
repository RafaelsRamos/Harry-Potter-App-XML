package com.scookie.harrypotterwiki.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.scookie.characterdetails.CharacterDetailsFragment
import com.scookie.feature.characterlisting.CharacterListingFragment
import com.scookie.harrypotterwiki.R
import com.scookie.navigation.Navigator
import com.scookie.navigation.screens.CharacterListingScreen
import com.scookie.navigation.screens.CharacterScreen
import com.scookie.navigation.screens.Screen

class NavigatorImpl(private val activity: AppCompatActivity): Navigator {

    private val fragManager get() = activity.supportFragmentManager

    override fun goBack() {
        fragManager.popBackStack()
    }

    override fun navigateTo(screen: Screen) {

        val fragment = fetchFragment(screen)

        fragManager
            .beginTransaction()
            .addToBackStack(screen.tag)
            .add(R.id.frag_container, fragment)
            .commit()

    }

    private fun fetchFragment(screen: Screen): Fragment {

        return when(screen) {
            is CharacterListingScreen   -> CharacterListingFragment.newInstance()
            is CharacterScreen          -> CharacterDetailsFragment.newInstance(screen.id)
            else                        -> throw Error("Invalid screen provider - $screen")
        }

    }

}