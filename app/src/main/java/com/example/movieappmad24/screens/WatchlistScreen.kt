package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieappmad24.SimpleBottomAppBar
import com.example.movieappmad24.SimpleTopAppBar
import com.example.movieappmad24.models.getMovies

@Composable
fun WatchListScreen(navController: NavController) {
    Scaffold(
        topBar = {
            SimpleTopAppBar(movie = null, navController = navController)
        },
        bottomBar = {
            SimpleBottomAppBar(navController = navController)
        }
    ) { innerPadding ->
        MovieList(
            modifier = Modifier.padding(innerPadding),
            movies = getMovies(),
            navController = navController
        )
    }
}
