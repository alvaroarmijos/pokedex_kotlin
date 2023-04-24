package com.example.pokedexkotlin.feature.pokemon_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokedexkotlin.R

class PokemonDetailActivity : AppCompatActivity() {

    companion object {
        const val POKEMON_ID = "pokemon_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
    }
}