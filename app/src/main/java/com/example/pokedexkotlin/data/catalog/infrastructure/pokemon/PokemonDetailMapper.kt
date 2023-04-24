package com.example.pokedexkotlin.data.catalog.infrastructure.pokemon

import AbilitieDto
import PokemonDetailDto
import TypesDto
import com.example.pokedexkotlin.data.catalog.domain.pokemon.Abilitie
import com.example.pokedexkotlin.data.catalog.domain.pokemon.PokemonDetail
import com.example.pokedexkotlin.data.catalog.domain.pokemon.Type

class PokemonDetailMapper {
    fun fromApiDto(apiDto: PokemonDetailDto): PokemonDetail {
        val id = apiDto.id
        val name = apiDto.name
        val height = apiDto.height
        val weight = apiDto.weight
        val imageUrl = convertApiImageUrl(apiDto.id)
        val abilities = fromApiAbilitieDtoList(apiDto.abilities)
        val types = fromApiTypesDtoList(apiDto.types)

        return PokemonDetail(
            id = id,
            name = name,
            height = height,
            weight = weight,
            imageUrl = imageUrl,
            abilities = abilities,
            types = types
        )

    }

    private fun fromApiAbilitieDto(apiAbilitieDto: AbilitieDto): Abilitie {
        val name = apiAbilitieDto.ability.name
        return Abilitie(name)
    }

    private fun fromApiTypeDto(apiTypeDto: TypesDto): Type {
        val name = apiTypeDto.type.name
        return Type(name)
    }


    private fun fromApiAbilitieDtoList(apiDtoList: List<AbilitieDto>): List<Abilitie> {
        return apiDtoList.map { fromApiAbilitieDto(it) }
    }

    private fun fromApiTypesDtoList(apiDtoList: List<TypesDto>): List<Type> {
        return apiDtoList.map { fromApiTypeDto(it) }
    }


    private fun convertApiImageUrl(id: Int): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/$id.svg"
    }


}