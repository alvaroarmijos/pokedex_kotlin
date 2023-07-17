package com.example.catalog.application

import com.example.catalog.pokemon.PokemonDetail
import com.example.catalog.pokemon.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonDetail @Inject constructor(private val pokemonRepository: PokemonRepository) {

    operator  fun invoke(id:Int): Flow<PokemonDetail?> = pokemonRepository.findById(id)
}