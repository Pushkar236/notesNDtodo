package com.pushkar.notesndtodos.presentation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.pushkar.notesndtodos.presentation.navigation.home
import com.pushkar.notesndtodos.presentation.navigation.note
import com.pushkar.notesndtodos.utils.AppRoutes

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.HomeScreen.route,
        enterTransition = { fadeIn(animationSpec = tween(400)) },
        exitTransition = { fadeOut(animationSpec = tween(400)) }
    ) {
        home(navController)
        note(navController)
    }
}