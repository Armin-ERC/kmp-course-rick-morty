package org.aerc.rickmortyapp.domain

import org.aerc.rickmortyapp.domain.model.CharacterModel

class GetRandomCharacterUseCase(private val repository: Repository) {
    suspend operator fun invoke(): CharacterModel {
        val random = (1..826).random()
        return repository.getSingleCharacter(random.toString())
    }
}
