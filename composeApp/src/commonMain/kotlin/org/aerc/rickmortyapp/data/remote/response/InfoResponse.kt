package org.aerc.rickmortyapp.data.remote.response

data class InfoResponse(
    val page: Int,
    val next: String?,
    val prev: String?
)
