package com.scookie.domainmodel

data class Character(

    val id: String = "",

    val name: String = "",

    val wand: Wand? = Wand(),

    val alternateNames: List<String> = emptyList(),

    val alternateActors: List<String> = emptyList(),

    val wizard: Boolean = false,

    val hogwartsStudent: Boolean = false,

    val hogwartsStaff: Boolean = false,

    val alive: Boolean = false,

    val species: String = "",

    val gender: String = "",

    val house: String = "",

    val dateOfBirth: String? = "",

    val yearOfBirth: Int = -1,

    val ancestry: String = "",

    val eyeColour: String = "",

    val hairColour: String = "",

    val patronus: String = "",

    val actor: String = "",

    val image: String = ""

)