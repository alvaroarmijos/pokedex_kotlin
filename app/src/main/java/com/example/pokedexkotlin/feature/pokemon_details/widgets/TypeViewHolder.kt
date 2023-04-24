package com.example.pokedexkotlin.feature.pokemon_details.widgets

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexkotlin.data.catalog.domain.pokemon.Type
import com.example.pokedexkotlin.databinding.ItemPokemonBinding
import com.example.pokedexkotlin.databinding.ItemTypeBinding

class TypeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemTypeBinding.bind(view)

    fun bind(typeItem: Type){
        binding.tvType.text = typeItem.name
    }
}