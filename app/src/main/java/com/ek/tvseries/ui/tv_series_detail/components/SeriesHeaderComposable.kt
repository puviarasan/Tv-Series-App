package com.ek.tvseries.ui.tv_series_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.ek.tvseries.common.Constants
import com.ek.tvseries.domain.model.SeriesDetailState

@Composable
fun SeriesHeaderComposable(state: SeriesDetailState) {
    Image(
        painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(Constants.IMAGE_URL + state.seriesDetail?.posterUrl)
                .crossfade(true)
                .build(),
            imageLoader = ImageLoader(LocalContext.current)
        ),
        contentDescription = "TV Series Poster",
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 16.dp),
        contentScale = ContentScale.FillWidth
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = state.seriesDetail?.name ?: "",
        style = MaterialTheme.typography.titleLarge
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "Synopsis:",
        style = MaterialTheme.typography.titleMedium
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = state.seriesDetail?.description ?: "",
        style = MaterialTheme.typography.bodyMedium
    )
    Spacer(modifier = Modifier.height(16.dp))
}