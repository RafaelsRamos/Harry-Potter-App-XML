package com.scookie.harrypotterwiki

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.scookie.data.repositories.characters.CharactersRepository
import com.scookie.navigation.Navigator
import com.scookie.navigation.screens.CharacterListingScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

    @Inject
    lateinit var navigatorProvider: Provider<Navigator>
    private val navigator get() = navigatorProvider.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator.navigateTo(CharacterListingScreen)
    }

}