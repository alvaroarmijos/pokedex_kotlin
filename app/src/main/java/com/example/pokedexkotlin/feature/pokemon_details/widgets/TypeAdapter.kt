package com.example.pokedexkotlin.feature.pokemon_details.widgets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexkotlin.R
import com.example.pokedexkotlin.data.catalog.domain.pokemon.Pokemon
import com.example.pokedexkotlin.data.catalog.domain.pokemon.Type

class TypeAdapter(
    var types: List<Type> = emptyList()
) : RecyclerView.Adapter<TypeViewHolder>() {

    fun updateList(typeList: List<Type>) {
        this.types = typeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_type, parent, false)
        return TypeViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: TypeViewHolder, position: Int) {
        viewHolder.bind(types[position])
    }

    override fun getItemCount(): Int = types.size
}