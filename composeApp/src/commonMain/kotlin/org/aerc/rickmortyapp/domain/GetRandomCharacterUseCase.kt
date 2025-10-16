package org.aerc.rickmortyapp.domain

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.aerc.rickmortyapp.domain.model.CharacterModel
import org.aerc.rickmortyapp.domain.model.CharacterOfTheDayModel
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

class GetRandomCharacterUseCase(private val repository: Repository) {
    suspend operator fun invoke(): CharacterModel {

        val characterOfTheDay: CharacterOfTheDayModel? = repository.getCharacterDB()
        val selectedDay = getCurrentDayOfTheYear()

        return if (characterOfTheDay != null && characterOfTheDay.selectedDay == selectedDay) {
            characterOfTheDay.characterModel
        } else {
            val result = generateRandomCharacter()
            repository.saveCharacterDB(CharacterOfTheDayModel(result, selectedDay))
            result
        }

    }

    private suspend fun generateRandomCharacter(): CharacterModel {
        val random = (1..826).random()
        return repository.getSingleCharacter(random.toString())
    }

    @OptIn(ExperimentalTime::class)
    private fun getCurrentDayOfTheYear(): String {
        val instant: Instant = Clock.System.now()
        val localTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())

        return "${localTime.dayOfYear}${localTime.year}"
    }
}
