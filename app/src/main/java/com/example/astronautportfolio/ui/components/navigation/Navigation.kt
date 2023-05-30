package com.example.astronautportfolio.ui.components.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.astronautportfolio.ui.components.TopNavBar
import com.example.astronautportfolio.ui.screens.detail.DetailScreen
import com.example.astronautportfolio.ui.screens.home.HomeScreen
import com.example.astronautportfolio.ui.screens.home.HomeViewModel
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun Navigation(navController: NavHostController, ) {
    NavHost(navController = navController, startDestination = Screen.MainScreen.route ) {
        composable(route = Screen.MainScreen.route) {
            Scaffold(
                topBar = {
                    TopNavBar()
                },
                content = {
                    val viewModel = hiltViewModel<HomeViewModel>()
                    val astronauts = viewModel.astronautPagingFlow.collectAsLazyPagingItems()
                    HomeScreen(astronauts, navController, paddingValues = it)
                }
            )
        }
        composable(
            route = Screen.DetailScreen.route + "/{id}",
            arguments = listOf(
                    navArgument("id") {
                        type = NavType.IntType
                        defaultValue = 0 }
            )
        ){ backStackEntry ->
            DetailScreen(id = backStackEntry.arguments?.getInt("id"))
        }
    }
}