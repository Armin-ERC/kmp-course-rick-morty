package org.aerc.rickmortyapp.di

import org.aerc.rickmortyapp.domain.GetRandomCharacterUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetRandomCharacterUseCase)
}
