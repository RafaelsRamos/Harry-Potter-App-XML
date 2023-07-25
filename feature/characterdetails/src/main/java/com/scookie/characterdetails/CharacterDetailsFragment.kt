package com.scookie.characterdetails

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.scookie.data.repositories.characters.CharactersRepository
import com.scookie.domainmodel.Character
import com.scookie.feature.characterdetails.R
import com.scookie.navigation.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class CharacterDetailsFragment: Fragment(R.layout.screen_character_details) {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var characterRepository: CharactersRepository

    private val characterId get() = requireArguments().getString(CHARACTER_ID_ARG)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            getCharacter(characterId)
        }
    }

    private suspend fun getCharacter(characterId: String) {
        val character = characterRepository.getCharacter(characterId)

        withContext(Dispatchers.Main) {
            setCharacterDetails(character)
        }
    }

    private fun setCharacterDetails(character: Character) {
        val characterImageView: ImageView = requireView().findViewById(R.id.character_iv)
        val nameTextView: TextView = requireView().findViewById(R.id.name_tv)
        val aliasesTextView: TextView = requireView().findViewById(R.id.aliases_tv)
        val speciesTextView: TextView = requireView().findViewById(R.id.species_tv)
        val genderTextView: TextView = requireView().findViewById(R.id.gender_tv)
        val houseTextView: TextView = requireView().findViewById(R.id.house_tv)
        val birthdateTextView: TextView = requireView().findViewById(R.id.birthdate_tv)
        val isWizardTextView: TextView = requireView().findViewById(R.id.is_wizard_tv)
        val ancestryTextView: TextView = requireView().findViewById(R.id.ancestry_tv)
        val eyeColorTextView: TextView = requireView().findViewById(R.id.eye_color_tv)
        val hairColorTextView: TextView = requireView().findViewById(R.id.hair_color_tv)
        val wandTextView: TextView = requireView().findViewById(R.id.wand_tv)
        val patronusTextView: TextView = requireView().findViewById(R.id.patronus_tv)
        val isStudentTextView: TextView = requireView().findViewById(R.id.is_student_tv)
        val isProfessorTextView: TextView = requireView().findViewById(R.id.is_professor_tv)
        val actorTextView: TextView = requireView().findViewById(R.id.actor_tv)
        val alternateActorsTextView: TextView = requireView().findViewById(R.id.alternate_actors_tv)
        val isAliveTextView: TextView = requireView().findViewById(R.id.is_alive_tv)

        characterImageView.loadImageFrom(character.image)
        nameTextView.text = character.name
        aliasesTextView.text = character.alternateNames.joinToString { "," }
        speciesTextView.text = character.species
        genderTextView.text = character.gender
        houseTextView.text = character.house
        birthdateTextView.text = character.dateOfBirth
        isWizardTextView.text = character.wizard.toYesNoString()
        ancestryTextView.text = character.ancestry
        eyeColorTextView.text = character.eyeColour
        hairColorTextView.text = character.hairColour
        patronusTextView.text = character.patronus
        isStudentTextView.text = character.hogwartsStudent.toYesNoString()
        isProfessorTextView.text = character.hogwartsStaff.toYesNoString()
        actorTextView.text = character.actor
        alternateActorsTextView.text = character.alternateActors.joinToString { "," }
        isAliveTextView.text = character.alive.toYesNoString()

        val wand = character.wand ?: return
        wandTextView.text = "Wood=${wand.wood} Core=${wand.core} Length=${wand.length}"
    }

    private fun ImageView.loadImageFrom(url: String) {
        this.visibility = View.VISIBLE
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.drawable.character_placeholder)
            .into(this)
    }

    private fun Boolean.toYesNoString() = if (this == true) "Yes" else "No"

    companion object {

        private const val CHARACTER_ID_ARG = "character_id"

        fun newInstance(id: String) = CharacterDetailsFragment().apply {
            arguments = bundleOf(CHARACTER_ID_ARG to id)
        }

    }

}