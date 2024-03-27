package com.example.movieappmad24.navigation

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object DetailScreen: Screen("detail_screen/{movieId}") {
        fun routeToMovieId(movieId: String) = "detail_screen/$movieId"
    }
    object WatchlistScreen: Screen("watchlist_screen")
}