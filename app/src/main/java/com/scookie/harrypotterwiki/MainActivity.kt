package com.scookie.harrypotterwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.scookie.network.retrofit.CharactersNetworkImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                getAllCharacters()
            }
        }
    }

    private suspend fun getAllCharacters() {
        val characters = CharactersNetworkImpl().getAllCharacters()
        println(characters)
    }
}