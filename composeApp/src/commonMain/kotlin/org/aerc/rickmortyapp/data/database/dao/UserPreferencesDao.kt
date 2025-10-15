package org.aerc.rickmortyapp.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import org.aerc.rickmortyapp.data.database.entity.CharacterOfTheDayEntity

@Dao
interface UserPreferencesDao {
    @Query("SELECT * FROM characterOfTheDay")
    suspend fun getCharacterOfTheDayDB(): CharacterOfTheDayEntity?
}
