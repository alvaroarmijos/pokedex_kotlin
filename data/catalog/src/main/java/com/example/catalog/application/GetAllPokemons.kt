package com.example.catalog.application

import com.example.catalog.pokemon.Pokemon
import com.example.catalog.pokemon.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllPokemons @Inject constructor(private val pokemonRepository: PokemonRepository) {

    operator  fun invoke(offset:Int): Flow<List<Pokemon>> = pokemonRepository.findAll(offset)
}