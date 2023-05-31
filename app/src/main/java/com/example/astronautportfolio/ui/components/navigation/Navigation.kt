package com.example.astronautportfolio.ui.components.navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.astronautportfolio.ui.components.TopNavBar
import com.example.astronautportfolio.ui.screens.detail.DetailScreen
import com.example.astronautportfolio.ui.screens.detail.DetailViewModel
import com.example.astronautportfolio.ui.screens.home.HomeScreen
import com.example.astronautportfolio.ui.screens.home.HomeViewModel
import com.example.astronautportfolio.model.overview.Result

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun Navigation(navController: NavHostController, detailViewModel: DetailViewModel) {
    NavHost(navController = navController, startDestination = Screen.MainScreen.route ) {
        composable(route = Screen.MainScreen.route) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(stringResource(com.example.astronautportfolio.R.string.home_nav))  },
                        navigationIcon = {
                            Icon(imageVector = Icons.Default.Star, contentDescription = "Menu Icon")
                        }
                    )
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
        ){backStackEntry ->
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(stringResource(com.example.astronautportfolio.R.string.detail_nav))  },
                        navigationIcon = {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Menu Icon",
                                modifier = Modifier.clickable { navController.navigateUp() }
                            )
                        }
                    )
                },
                content = {
                    val astronautData = navController.previousBackStackEntry?.savedStateHandle?.get<Result>("astronaut")
                    DetailScreen(id = backStackEntry.arguments?.getInt("id")?: 1, detailViewModel, astronautData, paddingValues = it)
                }
            )
        }
    }
}
