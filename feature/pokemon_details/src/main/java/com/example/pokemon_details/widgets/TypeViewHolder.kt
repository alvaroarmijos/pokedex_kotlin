package com.example.pokemon_details.widgets

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexkotlin.feature.pokemon_details.databinding.ItemTypeBinding

class TypeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemTypeBinding.bind(view)

    fun bind(typeItem: com.example.catalog.pokemon.Type){
        binding.tvType.text = typeItem.name
    }
}