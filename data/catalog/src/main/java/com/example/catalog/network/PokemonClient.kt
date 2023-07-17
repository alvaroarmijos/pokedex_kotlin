package com.example.catalog.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonClient {
    @GET("pokemon")
    suspend fun getPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 10
    ): PokemonsDto

    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): PokemonDetailDto?
}