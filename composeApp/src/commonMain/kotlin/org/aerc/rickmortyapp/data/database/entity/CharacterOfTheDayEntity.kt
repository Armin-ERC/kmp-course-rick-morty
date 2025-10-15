package org.aerc.rickmortyapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characterOfTheDay")
data class CharacterOfTheDayEntity(
//    @PrimaryKey(autoGenerate = true)
    @PrimaryKey
    val id: Int,
    val isAlive: Boolean,
    val name: String,
    val SelectedDate: String
)
