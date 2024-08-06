package com.ek.tvseries.ui.common_components

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvAppBar(name: String) {
    TopAppBar(
        title = { Text(name, maxLines = 1) },
        modifier = Modifier.background(MaterialTheme.colorScheme.surface)
    )
}