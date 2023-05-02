package com.example.pokedexkotlin.data.catalog.domain.pokemon

import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
     fun findAll(offset:Int): Flow<List<Pokemon>>
     fun findById(id:Int): Flow<PokemonDetail?>
}