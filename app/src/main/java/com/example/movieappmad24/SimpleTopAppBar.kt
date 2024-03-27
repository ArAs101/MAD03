package com.example.movieappmad24

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTopAppBar(navController: NavController, movie: Movie?) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    CenterAlignedTopAppBar(
        title = {
            if (currentRoute == Screen.HomeScreen.route) {
                Text("Movie App")
            } else if (currentRoute == Screen.WatchlistScreen.route) {
                Text("Watchlist")
            } else if (movie != null) {
                Text(movie.title)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            if (currentRoute == Screen.DetailScreen.route) {
                IconButton(
                    onClick = { navController.popBackStack() }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back to Home"
                    )
                }
            }
        }
    )
}