package com.pushkar.notesndtodos.presentation.state

import com.pushkar.notesndtodos.data.model.Note
import com.pushkar.notesndtodos.data.model.Tag
import com.pushkar.notesndtodos.data.model.Todo
import com.pushkar.notesndtodos.utils.Constants.ALL_NOTES_TAG


class HomeUiState {
    data class NotesListState(val notes : List<Note> = emptyList())
    data class TodosListState(val todos : List<Todo> = emptyList())
    data class TagsState(
        val tags: List<Tag> = emptyList(),
        val selectedTag: Tag = ALL_NOTES_TAG,
    )
    data class DarkModeState(val isInDarkMode: Boolean = false)
    data class SearchBarState(val searchQuery: String = "" )
    data class TabState(val selectedTab: Tabs = Tabs.Notes)
    data class DeleteModeState(val isInDeleteMode: Boolean = false)
    data class TodoDeleteDialogState(val isDeleteDialogShown: Boolean = false)
}