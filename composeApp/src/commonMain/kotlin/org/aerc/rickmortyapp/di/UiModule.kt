package org.aerc.rickmortyapp.di

import org.aerc.rickmortyapp.ui.home.tabs.characters.CharactersViewModel
import org.aerc.rickmortyapp.ui.home.tabs.episodes.EpisodesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::EpisodesViewModel)
    viewModelOf(::CharactersViewModel)
}
