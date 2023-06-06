package com.example.astronautportfolio.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import com.example.astronautportfolio.R

@Composable
fun AdditionalInfo(nationality: String, status: String, modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_medium), bottom = dimensionResource(R.dimen.padding_medium))
            ){
        Text(
            text = "About",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
        )
        Text(
            text = "$nationality | $status",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}