package com.example.pokedexkotlin.feature.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedexkotlin.databinding.ActivityHomeBinding
import com.example.pokedexkotlin.feature.home.widgets.PokemonAdapter
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
        homeViewModel.getPokemons()

        homeViewModel.pokemons.observe(this) {
            if (it.isNotEmpty()) {
                adapter.updateList(it)
            }
        }

        homeViewModel.isLoading.observe(this) {
            binding.pbHome.isVisible = it
        }

    }

    private fun addListeners() {
        binding.btnNext.setOnClickListener {
            homeViewModel.next()
        }
        binding.btnPrevious.setOnClickListener {
            homeViewModel.previous()
        }
    }

    private fun initUI() {
        adapter = PokemonAdapter { navigateToPokemonDetail(it) }
        binding.rvPokemons.setHasFixedSize(true)
        binding.rvPokemons.layoutManager = GridLayoutManager(this, 2)
        binding.rvPokemons.adapter = adapter
    }

    private fun navigateToPokemonDetail(id: Int) {
        println(id)
    }


}