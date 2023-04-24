package com.example.pokedexkotlin.feature.pokemon_details.widgets

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexkotlin.data.catalog.domain.pokemon.Ability
import com.example.pokedexkotlin.databinding.ItemAbilityBinding

class AbilityViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemAbilityBinding.bind(view)

    fun bind(abilityItem: Ability){
        binding.tvAbility.text = abilityItem.name
    }
}