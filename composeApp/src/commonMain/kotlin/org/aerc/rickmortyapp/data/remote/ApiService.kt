package org.aerc.rickmortyapp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.parameters
import org.aerc.rickmortyapp.data.remote.response.CharacterResponse
import org.aerc.rickmortyapp.data.remote.response.CharactersWrapperResponse
import org.aerc.rickmortyapp.data.remote.response.EpisodesWrapperResponse

class ApiService(private val client: HttpClient) {

    suspend fun getSingleCharacter(id: String): CharacterResponse {
        return client.get("/api/character/$id").body()
    }

    suspend fun getAllCharacters(page: Int): CharactersWrapperResponse {
        return client.get("/api/character/") {
            parameter("page", page)
        }.body()
    }

    suspend fun getAllEpisodes(page: Int): EpisodesWrapperResponse {
        return client.get("/api/episode"){
            parameter("page", page)
        }.body()
    }

}
