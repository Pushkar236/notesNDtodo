package com.pushkar.notesndtodos.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pushkar.notesndtodos.presentation.screens.NoteScreen
import com.pushkar.notesndtodos.utils.AppRoutes

fun NavGraphBuilder.note(navController: NavController) {
    composable(
        route = AppRoutes.NoteScreen.route + "/{${"noteId"}}",
        arguments = listOf(navArgument("noteId") { type = NavType.IntType })
    ) {
        it.arguments?.getInt("noteId")?.let { noteId ->
            NoteScreen(
                noteId = noteId,
                onNavigateBack = { navController.navigateUp() },
            )
        }
    }
}