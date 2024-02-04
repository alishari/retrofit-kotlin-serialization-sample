package com.lb7.retrofitsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lb7.retrofitsample.ui.main.MainScreen
import com.lb7.retrofitsample.ui.main.MainViewModel
import com.lb7.retrofitsample.ui.theme.RetrofitSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()
        setContent {
            val uiState = viewModel.uiState.collectAsStateWithLifecycle()
            RetrofitSampleTheme { MainScreen(uiState.value) }
        }
    }
}