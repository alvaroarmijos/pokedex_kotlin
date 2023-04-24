package com.example.pokedexkotlin.data.catalog.infrastructure.pokemon

import android.util.Log
import com.example.pokedexkotlin.data.catalog.common.network.PokemonClient
import com.example.pokedexkotlin.data.catalog.domain.pokemon.Pokemon
import com.example.pokedexkotlin.data.catalog.domain.pokemon.PokemonDetail
import com.example.pokedexkotlin.data.catalog.domain.pokemon.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class PokemonRepositoryApi @Inject constructor(
    private val apiClient: PokemonClient,
    private val mapper: PokemonMapper,
    private val mapperDetail: PokemonDetailMapper,
) : PokemonRepository {

    private suspend fun refresh(offset: Int): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            val dtoList = apiClient.getPokemons(offset)
            mapper.fromApiDtoList(dtoList.pokemons)
        }
    }

    override suspend fun findAll(offset: Int): List<Pokemon> {
        return refresh(offset)
    }

    override suspend fun findById(id: Int): PokemonDetail? {
        return withContext(Dispatchers.IO) {
            val dto = apiClient.getPokemon(id)
            dto?.let { mapperDetail.fromApiDto(it) }
        }
    }
}