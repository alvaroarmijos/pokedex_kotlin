package com.example.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.home.widgets.PokemonAdapter
import com.example.pokedexkotlin.feature.home.databinding.ActivityHomeBinding
import com.example.pokemon_details.PokemonDetailActivity
import com.example.pokemon_details.PokemonDetailActivity.Companion.POKEMON_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: PokemonAdapter

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        addListeners()

        homeViewModel.allPokemons.observe(this){
            if (it.isNotEmpty()){
                adapter.updateList(it)
            }
        }

    }

    private fun addListeners() {
        binding.btnNext.setOnClickListener {
            homeViewModel.next()
            binding.rvPokemons.scrollToPosition(0)

        }
        binding.btnPrevious.setOnClickListener {
            homeViewModel.previous()
            binding.rvPokemons.scrollToPosition(0)
        }
    }

    private fun initUI() {
        adapter = PokemonAdapter { navigateToPokemonDetail(it) }
        binding.rvPokemons.setHasFixedSize(true)
        binding.rvPokemons.layoutManager = GridLayoutManager(this, 2)
        binding.rvPokemons.adapter = adapter
    }

    private fun navigateToPokemonDetail(id: Int) {
        val intent = Intent(this, PokemonDetailActivity::class.java)
        intent.putExtra(POKEMON_ID, id)
        startActivity(intent)
    }


}