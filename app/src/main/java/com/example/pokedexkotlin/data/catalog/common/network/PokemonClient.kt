package com.example.pokedexkotlin.data.catalog.common.network

import com.example.pokedexkotlin.feature.home.vo.PokemonsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonClient {
    @GET("pokemon")
    suspend fun getPokemons(@Query("offset") offset:Int, @Query("limit") limit: Int = 10): PokemonsDto
}