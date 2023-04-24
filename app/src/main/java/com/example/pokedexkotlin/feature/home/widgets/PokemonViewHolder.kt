package com.example.pokedexkotlin.feature.home.widgets


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexkotlin.core.common.util.loadImage
import com.example.pokedexkotlin.data.catalog.domain.pokemon.Pokemon
import com.example.pokedexkotlin.databinding.ItemPokemonBinding


class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPokemonBinding.bind(view)

    fun bind(pokemonItem: Pokemon, onItemSelected: (Int) -> Unit) {
        binding.tvId.text = "#${pokemonItem.id}"

        binding.tvPokemonName.text = pokemonItem.name

        binding.ivPokemon.loadImage(pokemonItem.imageUrl)

        binding.root.setOnClickListener { onItemSelected(pokemonItem.id) }

    }
}