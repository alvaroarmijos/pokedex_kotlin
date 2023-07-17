package com.example.catalog.pokemon

import com.example.catalog.network.PokemonClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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

    override fun findAll(offset: Int): Flow<List<Pokemon>> {
        return flow {
            emit(refresh(offset))
        }
    }

    override fun findById(id: Int): Flow<PokemonDetail?> {
        return flow {
            val dto = apiClient.getPokemon(id)
            emit(dto?.let { mapperDetail.fromApiDto(it) })
        }
    }
}