package com.pushkar.notesndtodos.domain.repository

import com.pushkar.notesndtodos.data.model.Note
import com.pushkar.notesndtodos.data.model.NoteWithTags
import com.pushkar.notesndtodos.data.model.Tag
import com.pushkar.notesndtodos.data.model.TagWithNotes
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun insertNoteWithTags(note: Note, tags: List<Tag>)

    suspend fun getNoteWithTags(noteId: Int): NoteWithTags?

    suspend fun getTagWithNotes(tagName: String): TagWithNotes?

    fun getAllNotes(): Flow<List<Note>>

    fun getAllTags(): Flow<List<Tag>>

    // Retrieve only tags that have notes associated with them
    fun getTagsWithNotes(): Flow<List<Tag>>

    fun searchNotes(query: String): Flow<List<Note>?>

    suspend fun insertTag(tag: Tag)

    suspend fun deleteNote(note: Note)

    suspend fun deleteNoteWithTags(noteId:Int)
}