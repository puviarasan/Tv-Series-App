package com.ek.tvseries.ui.tv_series_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.ek.tvseries.R
import com.ek.tvseries.common.Constants
import com.ek.tvseries.domain.model.CastDetails

@Composable
fun CastItem(castDetails: CastDetails) {
    Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(Constants.IMAGE_URL + castDetails.profileImage)
                    .crossfade(true)
                    .placeholder(R.drawable.ic_place_holder)
                    .error(R.drawable.ic_error_image)
                    .build(),
                imageLoader = ImageLoader(LocalContext.current)
            ),
            contentDescription = "${castDetails.name} profile image",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(50.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            text = castDetails.name,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(top = 4.dp)
                .widthIn(max = 100.dp),
            maxLines = 2
        )
        Text(
            text = castDetails.job,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(top = 2.dp)
                .align(Alignment.CenterHorizontally)
                .widthIn(max = 100.dp),
            maxLines = 2
        )
    }
}