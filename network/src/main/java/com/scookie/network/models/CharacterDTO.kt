package com.scookie.network.models

import com.google.gson.annotations.SerializedName
import com.scookie.domainmodel.Character

data class CharacterDTO(

    @SerializedName("id")
    val id: String = "",

    @SerializedName("name")
    val name: String = "",

    @SerializedName("wand")
    val wand: WandDTO? = WandDTO(),

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
    val dateOfBirth: String? = "",

    @SerializedName("yearOfBirth")
    val yearOfBirth: Int = -1,

    @SerializedName("ancestry")
    val ancestry: String = "",

    @SerializedName("eyeColour")
    val eyeColour: String = "",

    @SerializedName("hairColour")
    val hairColour: String = "",

    @SerializedName("patronus")
    val patronus: String = "",

    @SerializedName("actor")
    val actor: String = "",

    @SerializedName("image")
    val image: String = ""

)

fun CharacterDTO.toModel() = Character(
    id = id,
    name = name,
    wand = wand?.toModel(),
    alternateNames = alternateNames,
    alternateActors = alternateActors,
    wizard = wizard,
    hogwartsStudent = hogwartsStudent,
    hogwartsStaff = hogwartsStaff,
    alive = alive,
    species = species,
    gender = gender,
    house = house,
    dateOfBirth = dateOfBirth,
    yearOfBirth = yearOfBirth,
    ancestry = ancestry,
    eyeColour = eyeColour,
    hairColour = hairColour,
    patronus = patronus,
    actor = actor,
    image = image,
)
