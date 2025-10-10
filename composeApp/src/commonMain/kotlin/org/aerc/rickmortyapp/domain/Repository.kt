package org.aerc.rickmortyapp.domain

import org.aerc.rickmortyapp.domain.model.CharacterModel

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
}
