package com.example.pokedexkotlin.feature.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokedexkotlin.R
import com.example.pokedexkotlin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}