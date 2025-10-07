package org.aerc.rickmortyapp

import androidx.compose.ui.window.ComposeUIViewController
import org.aerc.rickmortyapp.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }
