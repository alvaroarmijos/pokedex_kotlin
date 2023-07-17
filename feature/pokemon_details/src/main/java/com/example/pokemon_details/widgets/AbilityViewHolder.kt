package com.example.pokemon_details.widgets

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexkotlin.feature.pokemon_details.databinding.ItemAbilityBinding

class AbilityViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemAbilityBinding.bind(view)

    fun bind(abilityItem: com.example.catalog.pokemon.Ability){
        binding.tvAbility.text = abilityItem.name
    }
}