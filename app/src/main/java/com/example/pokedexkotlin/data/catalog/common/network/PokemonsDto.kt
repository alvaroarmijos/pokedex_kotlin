
import com.google.gson.annotations.SerializedName

data class PokemonsDto(
    @SerializedName("results") val pokemons:List<PokemonDto>
)

data class PokemonDto(
    @SerializedName("name") val name:String,
    @SerializedName("url") val url:String,
)

data class PokemonDetailDto(
    @SerializedName("name") val name:String,
    @SerializedName("id") val id:Int,
    @SerializedName("height") val height:Int,
    @SerializedName("weight") val weight:Int,
    @SerializedName("types") val types:List<TypesDto>,
    @SerializedName("abilities") val abilities:List<AbilitieDto>,
)

data class TypesDto(
    @SerializedName("type") val type: TypeDto
)

data class TypeDto(
    @SerializedName("name") val name: String
)

data class AbilitieDto(
    @SerializedName("ability") val ability: AbilitieDetailDto
)

data class AbilitieDetailDto(
    @SerializedName("name") val name: String
)