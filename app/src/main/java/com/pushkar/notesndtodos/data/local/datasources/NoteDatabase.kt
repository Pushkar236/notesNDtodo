package com.pushkar.notesndtodos.data.local.datasources

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pushkar.notesndtodos.data.local.converters.FilesPathsConverters
import com.pushkar.notesndtodos.data.local.dao.NoteDao
import com.pushkar.notesndtodos.data.model.Note
import com.pushkar.notesndtodos.data.model.NoteTagCrossRef
import com.pushkar.notesndtodos.data.model.Tag


const val NOTE_DATABASE_NAME = "notes_database"

@Database(
    entities = [Note::class, Tag::class, NoteTagCrossRef::class],
    version = 1,
    exportSchema = false)
@TypeConverters(FilesPathsConverters::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var instance: NoteDatabase? = null
        fun getInstance(context: Context): NoteDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): NoteDatabase {
            return Room.databaseBuilder(context, NoteDatabase::class.java, NOTE_DATABASE_NAME)
                .build()
        }
    }
}