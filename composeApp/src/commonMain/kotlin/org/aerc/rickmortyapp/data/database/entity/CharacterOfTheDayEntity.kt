package org.aerc.rickmortyapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.aerc.rickmortyapp.domain.model.CharacterModel
import org.aerc.rickmortyapp.domain.model.CharacterOfTheDayModel

@Entity(tableName = "characterOfTheDay")
data class CharacterOfTheDayEntity(
//    @PrimaryKey(autoGenerate = true)
    @PrimaryKey
    val id: Int,
    val isAlive: Boolean,
    val image: String,
    val name: String,
    val selectedDate: String
) {
    fun toDomain(): CharacterOfTheDayModel? {
        return CharacterOfTheDayModel(
            characterModel = CharacterModel(
                id = id,
                isAlive = isAlive,
                image = image,
                name = name
            ),
            selectedDay = selectedDate
        )
    }
}
