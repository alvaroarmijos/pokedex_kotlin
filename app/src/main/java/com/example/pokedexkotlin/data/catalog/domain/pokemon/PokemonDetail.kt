package com.example.pokedexkotlin.data.catalog.domain.pokemon

data class PokemonDetail(
    val name: String,
    val id: Int,
    val height: Int,
    val weight: Int,
    val imageUrl: String,
    val abilities: List<Abilitie>,
    val types: List<Type>

    )


data class Abilitie(
    val name: String,
)

data class Type(
    val name: String,
)