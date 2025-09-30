package org.aerc.rickmortyapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform