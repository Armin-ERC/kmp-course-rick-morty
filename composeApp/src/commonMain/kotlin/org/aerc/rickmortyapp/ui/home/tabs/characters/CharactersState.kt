package org.aerc.rickmortyapp.ui.home.tabs.characters

import org.aerc.rickmortyapp.domain.model.CharacterModel

data class CharactersState(
    val characterOfTheDay : CharacterModel? = null,
//    val characters : List<CharacterModel>
)
