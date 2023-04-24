package com.example.pokedexkotlin.di

import com.example.pokedexkotlin.data.catalog.common.network.PokemonClient
import com.example.pokedexkotlin.data.catalog.domain.pokemon.PokemonRepository
import com.example.pokedexkotlin.data.catalog.infrastructure.pokemon.PokemonDetailMapper
import com.example.pokedexkotlin.data.catalog.infrastructure.pokemon.PokemonMapper
import com.example.pokedexkotlin.data.catalog.infrastructure.pokemon.PokemonRepositoryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CatalogModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providePokemonApiClient(retrofit: Retrofit): PokemonClient {
        return retrofit.create(PokemonClient::class.java)
    }

    @Singleton
    @Provides
    internal fun providePokemonRepository(apiClient: PokemonClient): PokemonRepository {
        val mapper = PokemonMapper()
        val mapperDetail = PokemonDetailMapper()
        return PokemonRepositoryApi(apiClient, mapper, mapperDetail)
    }

//    @Singleton
//    @Provides
//    internal fun provideGetAllPokemons(
//        gameRepository: PokemonRepository,
//    ) = GetAllPokemons(gameRepository)
}