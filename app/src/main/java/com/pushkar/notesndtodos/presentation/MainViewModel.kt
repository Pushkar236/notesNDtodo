package com.pushkar.notesndtodos.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pushkar.notesndtodos.domain.repository.PreferencesRepository
import com.pushkar.notesndtodos.presentation.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class MainViewModel @Inject constructor(
    private val preferencesRepository: PreferencesRepository
): ViewModel() {

    private val _darkModeState = MutableStateFlow(HomeUiState.DarkModeState())
    val darkModeState = _darkModeState.asStateFlow()

    init {
        getDarkModeState()
    }

    private fun getDarkModeState() {
        viewModelScope.launch {
            preferencesRepository.isDarkTheme().collect{ isDarkTheme ->
                _darkModeState.value = darkModeState.value.copy(isInDarkMode = isDarkTheme)
            }
        }
    }
}