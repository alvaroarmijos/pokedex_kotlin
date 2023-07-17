package com.example.pokemon_details.widgets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catalog.pokemon.Ability
import com.example.pokedexkotlin.feature.pokemon_details.R

class AbilityAdapter(
    var abilities: List<Ability> = emptyList()
) : RecyclerView.Adapter<AbilityViewHolder>() {

    fun updateList(abilities: List<Ability>) {
        this.abilities = abilities
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ability, parent, false)
        return AbilityViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: AbilityViewHolder, position: Int) {
        viewHolder.bind(abilities[position])
    }

    override fun getItemCount(): Int = abilities.size
}