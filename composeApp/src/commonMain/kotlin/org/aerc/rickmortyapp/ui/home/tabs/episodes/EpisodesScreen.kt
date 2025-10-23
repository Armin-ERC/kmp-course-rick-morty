package org.aerc.rickmortyapp.ui.home.tabs.episodes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.collectAsLazyPagingItems
import org.aerc.rickmortyapp.domain.model.EpisodeModel
import org.aerc.rickmortyapp.domain.model.SeasonEpisode
import org.aerc.rickmortyapp.ui.components.PagingLoadingState
import org.aerc.rickmortyapp.ui.components.PagingType
import org.aerc.rickmortyapp.ui.components.PagingWrapper
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import rickmortyapp.composeapp.generated.resources.Res
import rickmortyapp.composeapp.generated.resources.season1
import rickmortyapp.composeapp.generated.resources.season2
import rickmortyapp.composeapp.generated.resources.season3
import rickmortyapp.composeapp.generated.resources.season4
import rickmortyapp.composeapp.generated.resources.season5
import rickmortyapp.composeapp.generated.resources.season6
import rickmortyapp.composeapp.generated.resources.season7

@Composable
fun EpisodesScreen() {
    val episodesViewModel = koinViewModel<EpisodesViewModel>()

    val state by episodesViewModel.state.collectAsState()
    val episodes = state.episodes.collectAsLazyPagingItems()

    Box(Modifier.fillMaxSize()) {
        PagingWrapper(
            pagingType = PagingType.ROW,
            pagingItems = episodes,
            initialView = {
                PagingLoadingState()
            },
            itemView = {
                EpisodeItemList(it)
            }
        )
    }
}

@Composable
fun EpisodeItemList(episode: EpisodeModel) {
    Column(modifier = Modifier.width(120.dp).padding(horizontal = 8.dp).clickable {

    }) {
        Image(
            modifier = Modifier.height(200.dp).fillMaxSize(),
            contentDescription = "episode image",
            contentScale = ContentScale.Inside,
            painter = painterResource(getSeasonImage(episode.season))
        )
    }
}

fun getSeasonImage(seasonEpisode: SeasonEpisode): DrawableResource {
    return when (seasonEpisode) {
        SeasonEpisode.SEASON_1 -> Res.drawable.season1
        SeasonEpisode.SEASON_2 -> Res.drawable.season2
        SeasonEpisode.SEASON_3 -> Res.drawable.season3
        SeasonEpisode.SEASON_4 -> Res.drawable.season4
        SeasonEpisode.SEASON_5 -> Res.drawable.season5
        SeasonEpisode.SEASON_6 -> Res.drawable.season6
        SeasonEpisode.SEASON_7 -> Res.drawable.season7
        SeasonEpisode.SEASON_8 -> Res.drawable.season1
        SeasonEpisode.UNKNOW -> Res.drawable.season1
    }
}
