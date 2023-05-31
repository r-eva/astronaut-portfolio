package com.example.astronautportfolio.ui.screens.detail

import android.icu.text.CaseMap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.astronautportfolio.model.overview.Result
import com.example.astronautportfolio.ui.components.ProfileImage

@Composable
fun DetailScreen (id: Int, viewModel: DetailViewModel, data: Result?, paddingValues: PaddingValues,) {

    val astronaut = viewModel.astronautDetailState.value

    LaunchedEffect(id) {
        viewModel.getAstronautDetailById(id)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().padding(top = paddingValues.calculateTopPadding())
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
                            style = MaterialTheme.typography.headlineMedium
                        )
                        ProfileImage(image = it.profileImage)
                        Spacer(modifier = Modifier.padding(dimensionResource(id = com.example.astronautportfolio.R.dimen.padding_small)))
                    }
                }
                item {
                    astronaut.apply {
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