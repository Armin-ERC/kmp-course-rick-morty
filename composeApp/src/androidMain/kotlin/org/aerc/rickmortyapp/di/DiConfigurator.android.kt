package org.aerc.rickmortyapp.di

import org.aerc.rickmortyapp.data.database.RickMortyDatabase
import org.aerc.rickmortyapp.data.database.getDataBase
import org.koin.core.module.Module
import org.koin.dsl.module
import kotlin.math.sin

actual fun platformModule(): Module {
    return module {
        single<RickMortyDatabase>{getDataBase(get())}
    }
}
