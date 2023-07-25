package com.scookie.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.scookie.domainmodel.Character
import com.scookie.domainmodel.Wand

@Entity
data class CharacterEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val wandWood: String,
    val wandCore: String,
    val wandLength: Float = 0F,
    val alternateNames: List<String>,
    val alternateActors: List<String>,
    val wizard: Boolean,
    val hogwartsStudent: Boolean,
    val hogwartsStaff: Boolean,
    val alive: Boolean,
    val species: String,
    val gender: String,
    val house: String,
    val dateOfBirth: String?,
    val yearOfBirth: Int,
    val ancestry: String,
    val eyeColour: String,
    val hairColour: String,
    val patronus: String,
    val actor: String,
    val image: String
)

fun List<Character>.toEntity() = this.map { it.toEntity() }
fun List<CharacterEntity>.toModel() = this.map { it.toModel() }

fun CharacterEntity.toModel() = Character(
    id = id,
    name = name,
    wand = Wand(wandWood, wandCore, wandLength),
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

fun Character.toEntity() = CharacterEntity(
    id = id,
    name = name,
    wandWood = wand!!.wood,
    wandCore = wand!!.core,
    wandLength = wand!!.length,
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
