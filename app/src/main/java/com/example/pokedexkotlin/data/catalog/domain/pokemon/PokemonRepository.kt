package com.example.pokedexkotlin.data.catalog.domain.pokemon

import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun findAll(offset:Int): List<Pokemon>
    suspend fun findById(id:Int): PokemonDetail?
}