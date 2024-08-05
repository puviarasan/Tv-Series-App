package com.ek.tvseries

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ek.tvseries.ui.Screen
import com.ek.tvseries.ui.theme.TvSeriesTheme
import com.ek.tvseries.ui.tv_series_detail.components.TvSeriesDetailComposable
import com.ek.tvseries.ui.tv_series_list.components.TvSeriesComposable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TvSeriesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.TvSeriesListScreen.route
                    ) {
                        composable(route = Screen.TvSeriesListScreen.route) {
                            TvSeriesComposable(navController = navController)
                        }
                        composable(route = Screen.TvSeriesDetailScreen.route + "/{series_id}") {
                            TvSeriesDetailComposable()
                        }
                    }
                }
            }
        }
    }
}

