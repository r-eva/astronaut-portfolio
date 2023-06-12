package com.example.astronautportfolio.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.astronautportfolio.R
import com.example.astronautportfolio.model.Astronaut
import com.example.astronautportfolio.ui.components.Flights
import com.example.astronautportfolio.ui.components.ProfileImage
import com.example.astronautportfolio.ui.screens.home.HomeViewModel
import com.example.astronautportfolio.ui.theme.AstronautPortfolioTheme

@Composable
fun DetailScreen (id: Int, data: Astronaut?, paddingValues: PaddingValues,) {

    val viewModel = hiltViewModel<DetailViewModel>()

    val astronautDetail = viewModel.astronautDetailState.value

    LaunchedEffect(id) {
        viewModel.getAstronautDetailById(id)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = paddingValues.calculateTopPadding())
    ) {
        data?.let {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item {
                    data.apply {
                        Text(text = it.name,
                            modifier = Modifier.padding(dimensionResource(id = com.example.astronautportfolio.R.dimen.padding_small)),
                            style = MaterialTheme.typography.displayLarge
                        )
                        ProfileImage(image = it.profileImage)
                        Spacer(modifier = Modifier.padding(dimensionResource(id = com.example.astronautportfolio.R.dimen.padding_small)))
                        Text(text = it.bio,
                            modifier = Modifier.padding(dimensionResource(id = com.example.astronautportfolio.R.dimen.padding_small)),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                item {
                    astronautDetail?.apply {
                        Text(text = "Flights:", modifier = Modifier.padding(dimensionResource(id = com.example.astronautportfolio.R.dimen.padding_small)),
                            style = MaterialTheme.typography.bodyLarge )
                        this.flights?.let { item -> Flights(flights = item) }
                        Spacer(modifier = Modifier.padding(dimensionResource(id = com.example.astronautportfolio.R.dimen.padding_medium)))
                    }
                }
            }
        }?: run {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DetailScreenPreview() {
    AstronautPortfolioTheme {
        val navController = rememberNavController()
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
                Text(
                    stringResource(R.string.home_nav),
                    modifier = Modifier.padding(it)
                )
            }
        )
    }
}