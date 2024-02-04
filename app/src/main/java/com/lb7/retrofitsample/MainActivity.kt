package com.lb7.retrofitsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lb7.retrofitsample.ui.main.MainScreen
import com.lb7.retrofitsample.ui.theme.RetrofitSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitSampleTheme {
                MainScreen()
            }
        }
    }
}