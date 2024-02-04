package com.lb7.retrofitsample.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lb7.retrofitsample.ui.theme.RetrofitSampleTheme

@Composable
fun MainScreen(uiState: MainUiState) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val text = when (uiState.userStatus) {
            UserState.Error -> "Something went wrong" // add specific error messages
            UserState.Loading -> "Loading ..."
            is UserState.Success -> uiState.userStatus.user.title
        }
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    RetrofitSampleTheme {
        MainScreen(
            uiState = MainUiState()
        )
    }
}