package com.example.catalog.di

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
    fun providePokemonApiClient(retrofit: Retrofit): com.example.catalog.network.PokemonClient {
        return retrofit.create(com.example.catalog.network.PokemonClient::class.java)
    }

    @Singleton
    @Provides
    internal fun providePokemonRepository(apiClient: com.example.catalog.network.PokemonClient): com.example.catalog.pokemon.PokemonRepository {
        val mapper = com.example.catalog.pokemon.PokemonMapper()
        val mapperDetail = com.example.catalog.pokemon.PokemonDetailMapper()
        return com.example.catalog.pokemon.PokemonRepositoryApi(apiClient, mapper, mapperDetail)
    }

//    @Singleton
//    @Provides
//    internal fun provideGetAllPokemons(
//        gameRepository: PokemonRepository,
//    ) = GetAllPokemons(gameRepository)
}