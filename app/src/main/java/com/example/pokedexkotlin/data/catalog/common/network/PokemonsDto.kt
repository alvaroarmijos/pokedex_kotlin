package com.example.pokedexkotlin.feature.home.vo

import com.google.gson.annotations.SerializedName

data class PokemonsDto(
    @SerializedName("results") val pokemons:List<PokemonDto>
)

data class PokemonDto(
    @SerializedName("name") val name:String,
    @SerializedName("url") val url:String,
)