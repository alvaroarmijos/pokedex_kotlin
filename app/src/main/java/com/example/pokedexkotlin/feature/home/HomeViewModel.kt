package com.example.pokedexkotlin.feature.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.example.pokedexkotlin.data.catalog.application.GetAllPokemons
import com.example.pokedexkotlin.data.catalog.domain.pokemon.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllPokemons: GetAllPokemons,
) : ViewModel() {

    private val offset = MutableLiveData(0)
    val allPokemons = offset.switchMap { getAllPokemons(it).asLiveData() }

    fun next() {
        if (offset.value!! < 1120){
            offset.value = offset.value?.plus(10)
        }
    }

    fun previous() {
        if (offset.value!! > 0) {
            offset.value = offset.value?.minus(10)
        }
    }
}