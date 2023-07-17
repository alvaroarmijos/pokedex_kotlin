package com.example.pokemon_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import com.example.catalog.application.GetPokemonDetail
import dagger.hilt.android.lifecycle.HiltViewModel
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