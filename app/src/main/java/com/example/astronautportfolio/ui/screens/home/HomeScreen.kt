package com.example.astronautportfolio.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.example.astronautportfolio.R
import com.example.astronautportfolio.ui.components.AstronautItem
import com.example.astronautportfolio.ui.theme.AstronautPortfolioTheme

@Composable
fun HomeScreen(
    navController: NavController,
    paddingValues: PaddingValues,
) {

    val viewModel = hiltViewModel<HomeViewModel>()
    val astronauts = viewModel.astronautPagingFlow.collectAsLazyPagingItems()

    val context = LocalContext.current

    LaunchedEffect(key1 = astronauts.loadState) {
        if(astronauts.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (astronauts.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if(astronauts.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = paddingValues.calculateTopPadding())
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(
                    count = astronauts.itemCount,
                    key = astronauts.itemKey(),
                    contentType = astronauts.itemContentType(
                        )
                ) { index ->
                    val item = astronauts[index]
                    if (item != null) {
                        AstronautItem(
                            navController = navController,
                            astronauts = item,
                            modifier = Modifier.padding(
                                dimensionResource(id = R.dimen.padding_small)
                            )
                        )
                    }
                }
                item {
                    if(astronauts.loadState.append is LoadState.Loading) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview() {
    AstronautPortfolioTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            stringResource(R.string.home_nav),
                            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small))
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
                HomeScreen(rememberNavController(), paddingValues = it)
            }
        )
    }
}