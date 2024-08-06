package com.ek.tvseries.ui.tv_series_detail.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ek.tvseries.domain.model.CastDetails

@Composable
fun CastList(castDetailsList: List<CastDetails>, text: String) {
    if (castDetailsList.isNotEmpty()) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        LazyRow {
            items(castDetailsList) {
                CastItem(castDetails = it)
            }
        }
    }
}