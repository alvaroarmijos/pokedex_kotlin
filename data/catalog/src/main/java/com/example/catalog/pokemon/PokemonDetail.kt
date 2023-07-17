package com.example.catalog.pokemon

data class PokemonDetail(
    val name: String,
    val id: Int,
    val height: Int,
    val weight: Int,
    val imageUrl: String,
    val abilities: List<Ability>,
    val types: List<Type>

    )


data class Ability(
    val name: String,
)

data class Type(
    val name: String,
)