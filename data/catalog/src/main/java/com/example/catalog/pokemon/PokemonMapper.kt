package com.example.catalog.pokemon

import com.example.catalog.network.PokemonDto

class PokemonMapper {
    fun fromApiDto(apiDto: PokemonDto): Pokemon {
        val id = convertApiId(apiDto.url)
        val name = apiDto.name
        val url = apiDto.url
        val imageUrl = convertApiImageUrl(id)

        return Pokemon(name = name, url = url, imageUrl = imageUrl, id = id)

    }

    fun fromApiDtoList(apiDtoList: List<PokemonDto>): List<Pokemon> {
        return apiDtoList.map { fromApiDto(it) }
    }

    private fun convertApiId(url: String): Int {
        return url.split("/").reversed()[1].toInt()
    }

    private fun convertApiImageUrl(id: Int): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/$id.svg"
    }
}