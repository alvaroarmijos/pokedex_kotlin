package com.example.pokedexkotlin.data.catalog.infrastructure.pokemon

import com.example.pokedexkotlin.data.catalog.common.network.PokemonClient
import com.example.pokedexkotlin.data.catalog.domain.pokemon.Pokemon
import com.example.pokedexkotlin.data.catalog.domain.pokemon.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject


class PokemonRepositoryApi @Inject constructor(
    private val apiClient: PokemonClient,
    private val mapper: PokemonMapper,
) : PokemonRepository{

    private suspend fun refresh(offset:Int): List<Pokemon> {
        return withContext(Dispatchers.IO){
            val dtoList = apiClient.getPokemons(offset)
            mapper.fromApiDtoList(dtoList.pokemons)
        }
    }

    override suspend fun findAll(offset:Int): List<Pokemon> {
        return refresh(offset)
    }
}