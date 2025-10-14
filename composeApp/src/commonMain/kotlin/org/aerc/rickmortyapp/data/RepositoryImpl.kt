package org.aerc.rickmortyapp.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.aerc.rickmortyapp.data.remote.ApiService
import org.aerc.rickmortyapp.data.remote.paging.CharactersPagingSource
import org.aerc.rickmortyapp.domain.Repository
import org.aerc.rickmortyapp.domain.model.CharacterModel

class RepositoryImpl(
    private val api: ApiService,
    private val charactersPagingSource: CharactersPagingSource
) : Repository {

    companion object {
        const val MAX_ITEMS = 20
        const val PREFETCH_ITEMS = 5
    }

    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id).toDomain()
    }

    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = { charactersPagingSource }
        ).flow
    }
}
