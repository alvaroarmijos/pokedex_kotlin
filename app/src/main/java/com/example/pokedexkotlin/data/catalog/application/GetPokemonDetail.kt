package com.example.pokedexkotlin.data.catalog.application

import com.example.pokedexkotlin.data.catalog.domain.pokemon.Pokemon
import com.example.pokedexkotlin.data.catalog.domain.pokemon.PokemonDetail
import com.example.pokedexkotlin.data.catalog.domain.pokemon.PokemonRepository
import javax.inject.Inject

class GetPokemonDetail @Inject constructor(private val pokemonRepository: PokemonRepository) {

    suspend operator  fun invoke(id:Int): PokemonDetail? = pokemonRepository.findById(id)
}