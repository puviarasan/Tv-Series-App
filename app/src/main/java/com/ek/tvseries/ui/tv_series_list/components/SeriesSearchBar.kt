package com.ek.tvseries.ui.tv_series_list.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.ek.tvseries.R
import com.ek.tvseries.domain.model.TvSeriesListState
import com.ek.tvseries.ui.tv_series_list.TvSeriesViewmodel

@Composable
fun SeriesSearchBar(
    state: TvSeriesListState,
    tvSeriesViewmodel: TvSeriesViewmodel,
    keyboardController: SoftwareKeyboardController?,
    focusManager: FocusManager
) {
    OutlinedTextField(
        value = state.searchQuery,
        onValueChange = { query -> tvSeriesViewmodel.onSearchQueryChanged(query) },
        label = { Text("Search TV Series") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search,
            keyboardType = KeyboardType.Text
        ),
        singleLine = true,
        keyboardActions = KeyboardActions(
            onSearch = {
                tvSeriesViewmodel.searchSeries()
                keyboardController?.hide()
                focusManager.clearFocus()
            }
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search icon"
            )
        }
    )
}