package com.example.home.widgets


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.common.util.loadImage
import com.example.pokedexkotlin.feature.home.databinding.ItemPokemonBinding


class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPokemonBinding.bind(view)

    fun bind(pokemonItem: com.example.catalog.pokemon.Pokemon, onItemSelected: (Int) -> Unit) {
        binding.tvId.text = "#${pokemonItem.id}"

        binding.tvPokemonName.text = pokemonItem.name

        binding.ivPokemon.loadImage(pokemonItem.imageUrl)

        binding.root.setOnClickListener { onItemSelected(pokemonItem.id) }

    }
}