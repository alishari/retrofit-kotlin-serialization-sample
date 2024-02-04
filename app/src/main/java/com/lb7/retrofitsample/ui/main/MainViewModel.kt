package com.lb7.retrofitsample.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lb7.retrofitsample.domain.model.User
import com.lb7.retrofitsample.domain.repo.UserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class MainUiState(
    val userStatus: UserState = UserState.Loading
)

sealed class UserState {
    data object Loading : UserState()
    data class Success(val user: User) : UserState()
    data object Error : UserState()
}

class MainViewModel(
    userRepo: UserRepo
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                userRepo.getUser("1")
                    .onSuccess { result ->
                        _uiState.update { it.copy(userStatus = UserState.Success(user = result)) }
                    }
                    .onFailure { error ->
                        Log.e("main", error.message.toString(), error)
                        _uiState.update { it.copy(userStatus = UserState.Error) }
                    }
            }
        }
    }
}