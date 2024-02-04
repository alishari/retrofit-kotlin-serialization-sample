package com.lb7.retrofitsample.ui.main

import androidx.lifecycle.ViewModel
import com.lb7.retrofitsample.domain.repo.UserRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MainUiState(
    val text: String = "Android"
)

class MainViewModel(
    userRepo: UserRepo
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()
}