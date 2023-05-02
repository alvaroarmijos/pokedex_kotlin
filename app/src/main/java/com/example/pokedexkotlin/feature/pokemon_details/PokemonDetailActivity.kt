package com.example.pokedexkotlin.feature.pokemon_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.LayoutDirection
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Orientation
import com.example.pokedexkotlin.core.common.util.loadImage
import com.example.pokedexkotlin.databinding.ActivityPokemonDetailBinding
import com.example.pokedexkotlin.feature.pokemon_details.widgets.AbilityAdapter
import com.example.pokedexkotlin.feature.pokemon_details.widgets.TypeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailActivity : AppCompatActivity() {

    companion object {
        const val POKEMON_ID = "pokemon_id"
    }

    private lateinit var binding: ActivityPokemonDetailBinding
    private lateinit var adapterType: TypeAdapter
    private lateinit var adapterAbility: AbilityAdapter
    private val pokemonDetailViewModel: PokemonDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
        addListeners()


        val id: Int = intent.getIntExtra(POKEMON_ID, 0)

        pokemonDetailViewModel.fetchPokemon(id)

        pokemonDetailViewModel.pokemon.observe(this) {

            binding.tvPokemonDetailId.text = "#${it?.id}"
            binding.tvPokemonDetailName.text = it?.name
            binding.tvPokemonHeight.text = "${it?.height} mm"
            binding.tvPokemonWeight.text = "${it?.weight} gr"
            it?.imageUrl?.let { it1 -> binding.ivPokemonDetail.loadImage(it1) }
            it?.let { it1 -> adapterType.updateList(it1.types) }
            it?.let { it1 -> adapterAbility.updateList(it1.abilities) }

        }
    }

    private fun initUi() {
        adapterType = TypeAdapter()
        binding.rvTypes.setHasFixedSize(true)
        binding.rvTypes.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTypes.adapter = adapterType

        adapterAbility = AbilityAdapter()
        binding.rvAbilities.setHasFixedSize(true)
        binding.rvAbilities.layoutManager = LinearLayoutManager(this)
        binding.rvAbilities.adapter = adapterAbility
    }

    private fun addListeners() {
        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}