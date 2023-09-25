package com.netanel.codeya

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.netanel.codeya.personaFeature.ui.PersonaScreen

/**
 * Created by netanelamar on 25/09/2023.
 * NetanelCA2@gmail.com
 */
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Persona.route) {
        /** Persona screen **/
        composable(Screen.Persona.route) {
            PersonaScreen(navController = navController)
        }

      /*  composable(
            Screen.MovieDetails.withArgs("{$MOVIE_ID}")
        ) { navBackStackEntry ->
            val movieId = navBackStackEntry.arguments?.getString(MOVIE_ID)
            MovieDetailsScreen(navController = navController, movieId= movieId.toString())
        }*/
    }
}