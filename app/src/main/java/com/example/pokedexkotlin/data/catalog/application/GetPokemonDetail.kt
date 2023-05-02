package com.example.pokedexkotlin.data.catalog.application

import com.example.pokedexkotlin.data.catalog.domain.pokemon.PokemonDetail
import com.example.pokedexkotlin.data.catalog.domain.pokemon.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonDetail @Inject constructor(private val pokemonRepository: PokemonRepository) {

    operator  fun invoke(id:Int): Flow<PokemonDetail?> = pokemonRepository.findById(id)
}