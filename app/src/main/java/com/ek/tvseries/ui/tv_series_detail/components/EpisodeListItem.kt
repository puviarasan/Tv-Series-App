package com.ek.tvseries.ui.tv_series_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.ek.tvseries.R
import com.ek.tvseries.common.Constants
import com.ek.tvseries.domain.model.EpisodeDetailModel

@Composable
fun EpisodeListItem(episodeDetailModel: EpisodeDetailModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(Constants.IMAGE_URL + episodeDetailModel.episodeImageUrl)
                        .crossfade(true)
                        .placeholder(R.drawable.ic_place_holder)
                        .error(R.drawable.ic_error_image)
                        .build(),
                    imageLoader = ImageLoader(LocalContext.current)
                ),
                contentDescription = "TV Series Poster",
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Column {
                Text(
                    text = "Episode ${episodeDetailModel.episodeNumber}",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = episodeDetailModel.name,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}