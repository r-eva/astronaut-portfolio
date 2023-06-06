package com.example.astronautportfolio

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.astronautportfolio.ui.theme.AstronautPortfolioTheme
import com.example.astronautportfolio.ui.components.navigation.Navigation
import com.example.astronautportfolio.ui.screens.detail.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var detailViewModel: DetailViewModel

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        println("masuk main android")
        super.onCreate(savedInstanceState)
        initVM()
        setContent {
            AstronautPortfolioTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    val navController: NavHostController = rememberNavController()
                    Navigation(navController = navController, detailViewModel = detailViewModel)
                }
            }
        }
    }
    private fun initVM() {
        detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]
    }
}