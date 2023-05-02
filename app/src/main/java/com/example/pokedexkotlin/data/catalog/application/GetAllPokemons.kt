package com.example.pokedexkotlin.data.catalog.application

import com.example.pokedexkotlin.data.catalog.domain.pokemon.Pokemon
import com.example.pokedexkotlin.data.catalog.domain.pokemon.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllPokemons @Inject constructor(private val pokemonRepository: PokemonRepository) {

    operator  fun invoke(offset:Int): Flow<List<Pokemon>> = pokemonRepository.findAll(offset)
}