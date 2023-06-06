package com.example.astronautportfolio.ui.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.astronautportfolio.model.overview.Astronaut
import com.example.astronautportfolio.ui.components.Flights
import com.example.astronautportfolio.ui.components.ProfileImage

@Composable
fun DetailScreen (id: Int, viewModel: DetailViewModel, data: Astronaut?, paddingValues: PaddingValues,) {

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