package com.ek.tvseries.ui.tv_series_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ek.tvseries.domain.model.SeasonDetailState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeasonsDropDown(state: SeasonDetailState, numberOfSeasons: Int?) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Season 1") }
    Column {
        Text(
            text = "Seasons",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                modifier = Modifier.menuAnchor(),
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) }
            )

            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                for (season in 1..numberOfSeasons!!) {
                    DropdownMenuItem(text = { Text(text = "Season $season") }, onClick = {
                        expanded = false
                        selectedText = "Season $season"
                        state.onSeasonSelected(season)
                    })
                }
            }
        }
    }

}