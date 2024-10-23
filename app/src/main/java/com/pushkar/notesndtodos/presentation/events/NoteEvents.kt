package com.pushkar.notesndtodos.presentation.events

import com.pushkar.notesndtodos.data.model.Note
import com.pushkar.notesndtodos.data.model.Tag

sealed class NoteEvents {
    data class OnGetNote(val noteId: Int) : NoteEvents()
    data object OnNewNote : NoteEvents()
    data class OnTitleChange(val title: String) : NoteEvents()
    data class OnContentTextChange(val contentText: String) : NoteEvents()
    data class OnSaveChanges(val note: Note,val tags:List<Tag>) : NoteEvents()
    data object OnCreateNewTag : NoteEvents()
    data object OnCancelCreatingNewTag : NoteEvents()
    data class OnSaveNewTag(val tagName: String) : NoteEvents()
    data class OnNewTagNameChange(val tagName: String) : NoteEvents()
    data class OnSelectTag(val tag: Tag) : NoteEvents()
    data class OnUnselectTag(val tag: Tag) : NoteEvents()
    data class OnEditNote(val isEditing:Boolean = false) : NoteEvents()
    data class OnConfirmDeleteNote(val note: Note) : NoteEvents()
    data object OnDeleteClick : NoteEvents()
    data object OnCancelDelete : NoteEvents()
}