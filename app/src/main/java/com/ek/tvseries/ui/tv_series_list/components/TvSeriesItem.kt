package com.ek.tvseries.ui.tv_series_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.ek.tvseries.common.Constants
import com.ek.tvseries.domain.model.TvSeriesListModel

@Composable
fun TvSeriesItem(
    tvSeries: TvSeriesListModel,
    onItemClick: (TvSeriesListModel) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(Constants.IMAGE_URL + tvSeries.imageUrl)
                            .crossfade(true)
                            .build(),
                        imageLoader = ImageLoader(LocalContext.current)
                    ),
                    contentDescription = "TV Series Poster",
                    modifier = Modifier
                        .size(180.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .clickable {
                            onItemClick(tvSeries)
                        }
                        .padding(top = 8.dp)
                )
            }

            Column(modifier = Modifier.padding(8.dp)) {
                Text(tvSeries.name, style = MaterialTheme.typography.titleSmall, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Text(
                    tvSeries.overView,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
fun TvSeriesItemPreview() {
    TvSeriesItem(
        tvSeries = TvSeriesListModel(
            name = "stranger things",
            overView = "When a young boy disappears, his mother must confront terrifying forces.",
            imageUrl = "",
            seriesId = 0
        ),
        onItemClick = {}
    )
}