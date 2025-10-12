package org.aerc.rickmortyapp.data.remote.response

import kotlinx.serialization.Serializable
import org.aerc.rickmortyapp.domain.model.CharacterModel

@Serializable
data class CharacterResponse(
    val id: Int,
    val status: String,
    val image: String,
    val name: String
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id,
            isAlive = status.lowercase() == "alive",
            image = image,
            name = name
        )
    }
}
