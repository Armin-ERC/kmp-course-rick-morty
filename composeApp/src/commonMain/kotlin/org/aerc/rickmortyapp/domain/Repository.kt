package org.aerc.rickmortyapp.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.aerc.rickmortyapp.domain.model.CharacterModel

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
    fun getAllCharacters() : Flow<PagingData<CharacterModel>>
    suspend fun getCharacterDB()
}
