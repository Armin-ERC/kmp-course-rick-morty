package org.aerc.rickmortyapp.ui.home.tabs.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.aerc.rickmortyapp.domain.Repository

class EpisodesViewModel(private val repository: Repository) : ViewModel() {
    private val _state = MutableStateFlow<EpisodesState>(EpisodesState())
    val state: StateFlow<EpisodesState> = _state

    init {
        _state.update { state -> state.copy(
            episodes = repository.getAllEpisodes().cachedIn(viewModelScope)
        ) }
    }

}
