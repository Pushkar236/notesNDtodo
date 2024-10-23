package com.pushkar.notesndtodos.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pushkar.notesndtodos.presentation.screens.HomeScreen
import com.pushkar.notesndtodos.utils.AppRoutes

fun NavGraphBuilder.home(navController: NavController) {
    composable(AppRoutes.HomeScreen.route) {
        HomeScreen { noteId ->
            navController.navigate(AppRoutes.NoteScreen.route + "/$noteId")
        }
    }
}