package com.example.astronautportfolio.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import com.example.astronautportfolio.model.detail.Flight

@Composable
fun Flights(flights:List<Flight>){
    Column {
        for ((index, flight) in flights.withIndex()) {
            Box(
                modifier = Modifier,
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = flight.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = dimensionResource(id = com.example.astronautportfolio.R.dimen.padding_small)),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Start
                )
            }
        }
    }

}