package com.scookie.feature.characterlisting

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scookie.data.repositories.characters.CharactersRepository
import com.scookie.domainmodel.Character
import com.scookie.navigation.Navigator
import com.scookie.navigation.screens.CharacterScreen
import com.scookie.ui.GridSpacingItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class CharacterListingFragment: Fragment(R.layout.screen_character_listing) {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var characterRepository: CharactersRepository

    private val recyclerView: RecyclerView by lazy { requireView().findViewById(R.id.characters_rv) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            getAllCharacters()
        }
    }

    private suspend fun getAllCharacters() {
        val characters = characterRepository.getAllCharacters()

        withContext(Dispatchers.Main) {
            recyclerView.setup(characters)
        }
    }

    private fun RecyclerView.setup(characters: List<Character>) {
        adapter = CharacterListAdapter(characters.toMutableList(), ::onCharacterClick)
        layoutManager = GridLayoutManager(context, GRID_SPAN)
        addItemDecoration(GridSpacingItemDecoration(GRID_SPAN, 45))
    }

    private fun onCharacterClick(characterId: String) {
        navigator.navigateTo(CharacterScreen(characterId))
    }

    companion object {

        private const val GRID_SPAN = 2

        fun newInstance() = CharacterListingFragment()

    }

}