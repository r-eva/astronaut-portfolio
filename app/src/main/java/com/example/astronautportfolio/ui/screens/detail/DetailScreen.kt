package com.example.astronautportfolio.ui.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

@Composable
fun DetailScreen (id: Int, viewModel: DetailViewModel = remember { DetailViewModel() }) {

    val astronaut = viewModel.astronautDetailState.value

    LaunchedEffect(id) {
        viewModel.getAstronautDetailById(id)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = id.toString())
        if (astronaut != null) {
            astronaut.flights?.get(0)?.let { Text(text = it.name) }
        }
    }
}