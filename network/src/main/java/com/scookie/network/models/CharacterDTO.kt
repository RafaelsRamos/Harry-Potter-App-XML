package com.scookie.network.models

import com.google.gson.annotations.SerializedName

data class CharacterDTO(

    @SerializedName("id")
    val id: String = "",

    @SerializedName("name")
    val name: String = "",

    @SerializedName("alternate_names")
    val alternateNames: List<String> = emptyList(),

    @SerializedName("alternate_actors")
    val alternateActors: List<String> = emptyList(),

    @SerializedName("wizard")
    val wizard: Boolean = false,

    @SerializedName("hogwartsStudent")
    val hogwartsStudent: Boolean = false,

    @SerializedName("hogwartsStaff")
    val hogwartsStaff: Boolean = false,

    @SerializedName("alive")
    val alive: Boolean = false,

    @SerializedName("species")
    val species: String = "",

    @SerializedName("gender")
    val gender: String = "",

    @SerializedName("house")
    val house: String = "",

    @SerializedName("dateOfBirth")
    val dateOfBirth: String = "",

    @SerializedName("yearOfBirth")
    val yearOfBirth: Int = -1,

    @SerializedName("ancestry")
    val ancestry: String = "",

    @SerializedName("eyeColour")
    val eyeColour: String = "",

    @SerializedName("hairColour")
    val hairColour: String = "",

    @SerializedName("wand")
    val wand: WandDTO? = WandDTO(),

    @SerializedName("patronus")
    val patronus: String = "",

    @SerializedName("actor")
    val actor: String = "",

    @SerializedName("image")
    val image: String = ""

)
