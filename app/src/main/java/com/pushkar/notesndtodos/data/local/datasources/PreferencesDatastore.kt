package com.pushkar.notesndtodos.data.local.datasources

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore


class PreferencesDatastore  {
    companion object{
        val Context.preferences: DataStore<Preferences> by preferencesDataStore(
            name = "com.pushkar.notesndtodos.user_preferences"
        )
    }
}