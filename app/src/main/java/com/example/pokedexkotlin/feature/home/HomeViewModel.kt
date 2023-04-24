package com.example.pokedexkotlin.feature.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedexkotlin.data.catalog.application.GetAllPokemons
import com.example.pokedexkotlin.data.catalog.domain.pokemon.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllPokemons: GetAllPokemons,
) : ViewModel() {

    val pokemons = MutableLiveData<List<Pokemon>>()
    val isLoading = MutableLiveData<Boolean>()

    val offset = MutableLiveData(0)

    fun next() {
        if (offset.value!! < 1120) {
            offset.value = offset.value?.plus(10)
            getPokemons()
        }
    }

    fun previous() {
        if (offset.value!! > 0) {
            offset.value = offset.value?.minus(10)
            getPokemons()
        }
    }

    fun getPokemons() {
        viewModelScope.launch {
            isLoading.postValue(true)
            Log.i("alvaro", "getPokemons")
            val result = offset.value?.let { getAllPokemons(it) }
            if (!result.isNullOrEmpty()) {
                pokemons.postValue(result!!)
                isLoading.postValue(false)
            }
        }
    }

}