package com.example.astronautportfolio.ui.components.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.astronautportfolio.R
import com.example.astronautportfolio.ui.screens.detail.DetailScreen
import com.example.astronautportfolio.ui.screens.detail.DetailViewModel
import com.example.astronautportfolio.ui.screens.home.HomeScreen
import com.example.astronautportfolio.model.overview.Astronaut

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun Navigation(navController: NavHostController, detailViewModel: DetailViewModel) {
    NavHost(navController = navController, startDestination = Screen.MainScreen.route ) {
        composable(route = Screen.MainScreen.route) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(stringResource(com.example.astronautportfolio.R.string.home_nav),
                                modifier = Modifier.padding(start = dimensionResource(id = com.example.astronautportfolio.R.dimen.padding_small))
                            )
                                },
                        navigationIcon = {
                            Icon(imageVector = Icons.Default.Star, 
                                contentDescription = "Menu Icon",
                                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small))
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = MaterialTheme.colorScheme.primary)
                    )
                },
                content = {
                    HomeScreen(navController, paddingValues = it)
                }
            )
        }
        composable(Screen.DetailScreen.route + "/{id}"){backStackEntry ->
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(stringResource(com.example.astronautportfolio.R.string.detail_nav),
                            modifier = Modifier.padding(start = dimensionResource(id = com.example.astronautportfolio.R.dimen.padding_small))
                            )  },
                        navigationIcon = {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Menu Icon",
                                modifier = Modifier
                                    .padding(start = dimensionResource(id = R.dimen.padding_small))
                                    .clickable { navController.navigateUp() }
                            )
                        }
                    )
                },
                content = {
                    val astronautData = navController.previousBackStackEntry?.savedStateHandle?.get<Astronaut>("astronaut")
                    DetailScreen(
                        id = backStackEntry.arguments?.getString("id")?.toInt() ?: 1,
                        detailViewModel, astronautData, paddingValues = it)
                }
            )
        }
    }
}
