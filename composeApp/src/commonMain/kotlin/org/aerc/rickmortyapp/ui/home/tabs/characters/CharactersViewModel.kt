package org.aerc.rickmortyapp.ui.home.tabs.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.aerc.rickmortyapp.domain.GetRandomCharacterUseCase
import org.aerc.rickmortyapp.domain.Repository
import org.aerc.rickmortyapp.domain.model.CharacterModel

class CharactersViewModel(
    private val getRandomCharacter: GetRandomCharacterUseCase,
    private val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow<CharactersState>(CharactersState())
    val state: StateFlow<CharactersState> = _state

    init {
        viewModelScope.launch {
            val result: CharacterModel = withContext(Dispatchers.IO) {
                getRandomCharacter()
            }
            _state.update { it.copy(characterOfTheDay = result) }
        }
        getAllCharacters()
    }

    private fun getAllCharacters() {
        _state.update { state ->
            state.copy(
                characters = repository.getAllCharacters()
            )
        }
    }
}
