package com.example.pokedexkotlin.feature.pokemon_details

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.pokedexkotlin.data.catalog.application.GetPokemonDetail
import com.example.pokedexkotlin.data.catalog.domain.pokemon.PokemonDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetail: GetPokemonDetail,
) : ViewModel() {

    private val pokemonIdController = MutableLiveData<Int>()
    val pokemon = pokemonIdController.switchMap { getPokemonDetail(it).asLiveData() }

    fun fetchPokemon(idPokemon: Int){
        pokemonIdController.value = idPokemon
    }
}