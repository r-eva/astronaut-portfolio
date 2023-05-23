package com.example.astronautportfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.astronautportfolio.ui.screens.home.HomeViewModel
import com.example.astronautportfolio.ui.screens.home.OverviewScreen
import com.example.astronautportfolio.ui.theme.AstronautPortfolioTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AstronautPortfolioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel = hiltViewModel<HomeViewModel>()
                    val astronauts = viewModel.astronautPagingFlow.collectAsLazyPagingItems()
                    OverviewScreen(astronauts = astronauts)
                }
            }
        }
    }
}