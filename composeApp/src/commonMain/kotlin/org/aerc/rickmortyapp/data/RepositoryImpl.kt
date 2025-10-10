package org.aerc.rickmortyapp.data

import org.aerc.rickmortyapp.data.remote.ApiService
import org.aerc.rickmortyapp.domain.Repository
import org.aerc.rickmortyapp.domain.model.CharacterModel

class RepositoryImpl(private val api: ApiService) : Repository {
    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id).toDomain()
    }
}
