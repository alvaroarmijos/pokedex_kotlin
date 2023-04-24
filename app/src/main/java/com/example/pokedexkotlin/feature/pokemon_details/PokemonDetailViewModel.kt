package com.example.pokedexkotlin.feature.pokemon_details

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    val pokemon = MutableLiveData<PokemonDetail>()
    val isLoading = MutableLiveData<Boolean>()

    fun getPokemon(id:Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPokemonDetail(id)
            if (result != null) {
                pokemon.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }
}