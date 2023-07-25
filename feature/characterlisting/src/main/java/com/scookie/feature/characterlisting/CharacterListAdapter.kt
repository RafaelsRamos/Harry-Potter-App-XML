package com.scookie.feature.characterlisting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.scookie.domainmodel.Character
import com.scookie.feature.characterlisting.CharacterListAdapter.ViewHolder

class CharacterListAdapter(
    private val characters: MutableList<Character>,
    private val onCharacterClick: (String) -> Unit
): RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount() = characters.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.component_character, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val characterImageView: ImageView = view.findViewById(R.id.character_iv)
        private val nameTextView: TextView = view.findViewById(R.id.name_tv)
        private val aliasTextView: TextView = view.findViewById(R.id.alias_tv)
        fun bind(character: Character) {

            itemView.setOnClickListener {
                onCharacterClick.invoke(character.id)
            }

            characterImageView.loadImageFrom(character.image)

            nameTextView.text = character.name

            val alias = character.alternateNames.firstOrNull()

            if (alias != null) {
                showAlias(alias)
            } else {
                hideAlias()
            }
        }

        private fun showAlias(alias: String) {
            aliasTextView.text = alias
            aliasTextView.visibility = View.VISIBLE
        }

        private fun hideAlias() {
            aliasTextView.visibility = View.GONE
        }

        private fun ImageView.loadImageFrom(url: String) {
            Glide.with(context)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade(200))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.character_placeholder)
                .into(this)

        }

    }

}