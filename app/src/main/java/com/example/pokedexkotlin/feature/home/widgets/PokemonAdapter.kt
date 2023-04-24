package com.example.pokedexkotlin.feature.home.widgets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexkotlin.R
import com.example.pokedexkotlin.data.catalog.domain.pokemon.Pokemon

class PokemonAdapter(
    var pokemonList: List<Pokemon> = emptyList(),
    private val onItemSelected: (Int) -> Unit
) : RecyclerView.Adapter<PokemonViewHolder>(){

    fun updateList(pokemonList: List<Pokemon>) {
        this.pokemonList = pokemonList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(layoutInflater.inflate(R.layout.item_pokemon, parent, false))
    }

    override fun onBindViewHolder(viewHolder: PokemonViewHolder, position: Int) {
        viewHolder.bind(pokemonList[position], onItemSelected)
    }

    override fun getItemCount(): Int = pokemonList.size
}