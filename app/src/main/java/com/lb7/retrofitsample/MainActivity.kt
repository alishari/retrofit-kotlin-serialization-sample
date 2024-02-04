package com.lb7.retrofitsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lb7.retrofitsample.ui.main.MainScreen
import com.lb7.retrofitsample.ui.main.MainViewModel
import com.lb7.retrofitsample.ui.theme.RetrofitSampleTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel by viewModel<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val uiState = viewModel.uiState.collectAsStateWithLifecycle()
            RetrofitSampleTheme { MainScreen(uiState.value) }
        }
    }
}