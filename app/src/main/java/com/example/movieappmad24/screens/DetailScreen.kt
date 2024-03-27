package com.example.movieappmad24.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.movieappmad24.SimpleBottomAppBar
import com.example.movieappmad24.SimpleTopAppBar
import com.example.movieappmad24.models.getMovies

@Composable
fun DetailScreen(navController: NavHostController, movieId: String?) {
    val selectedMovie = getMovies().find { it.id == movieId }
    Scaffold(
        topBar = {
            SimpleTopAppBar(navController = navController, movie = selectedMovie)
        },
        bottomBar = {
            SimpleBottomAppBar(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            if (selectedMovie != null) {
                MovieRow(movie = selectedMovie)
                LazyRow(
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    items(selectedMovie.images) { imageUrl ->
                        Card(
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 5.dp),
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(imageUrl),
                                contentDescription = "Movie image",
                                modifier = Modifier.size(250.dp, 300.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }
            } else Text(text = "Error! Movie details are unavailable!")
        }
    }
}