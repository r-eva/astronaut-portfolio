package com.example.astronautportfolio.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.astronautportfolio.R

@Composable
fun BasicInfoCol(name: String, age: Int, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = name,
            style = MaterialTheme.typography.displayMedium,
            modifier = modifier.padding(top = dimensionResource(id = R.dimen.padding_small))
        )
        Text(
            text = "Age: $age",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}