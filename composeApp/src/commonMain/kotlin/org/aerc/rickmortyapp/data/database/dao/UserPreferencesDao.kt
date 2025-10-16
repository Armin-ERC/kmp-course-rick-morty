package org.aerc.rickmortyapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.aerc.rickmortyapp.data.database.entity.CharacterOfTheDayEntity

@Dao
interface UserPreferencesDao {
    @Query("SELECT * FROM characterOfTheDay")
    suspend fun getCharacterOfTheDayDB(): CharacterOfTheDayEntity?

    @Insert(entity = CharacterOfTheDayEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacterOfTheDayDB(characterOfTheDayEntity: CharacterOfTheDayEntity)
}
