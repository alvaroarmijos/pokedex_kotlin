package com.example.pokedexkotlin.feature.pokemon_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.pokedexkotlin.core.common.util.loadImage
import com.example.pokedexkotlin.databinding.ActivityPokemonDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailActivity : AppCompatActivity() {

    companion object {
        const val POKEMON_ID = "pokemon_id"
    }

    private lateinit var binding: ActivityPokemonDetailBinding
    private val pokemonDetailViewModel : PokemonDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addListeners()


        val id: Int = intent.getIntExtra(POKEMON_ID, 0)

        pokemonDetailViewModel.getPokemon(id)

        pokemonDetailViewModel.pokemon.observe(this){
            binding.tvPokemonDetailId.text = "#${it.id}"
            binding.tvPokemonDetailName.text = it.name
            binding.tvPokemonHeight.text = "${it.height} mm"
            binding.tvPokemonWeight.text = "${it.weight} gr"
            binding.ivPokemonDetail.loadImage(it.imageUrl)

        }
    }

    private fun addListeners() {
        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}