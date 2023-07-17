package com.example.home


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import com.example.catalog.application.GetAllPokemons
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

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