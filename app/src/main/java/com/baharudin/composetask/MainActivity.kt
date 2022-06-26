package com.baharudin.composetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.baharudin.composetask.presentation.navigation.NavGraph
import com.baharudin.composetask.ui.theme.ComposeTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navConroller : NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTaskTheme {
                navConroller = rememberNavController()
                NavGraph(navHostController = navConroller)
            }
        }
    }
}
