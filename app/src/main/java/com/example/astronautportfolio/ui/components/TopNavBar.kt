package com.example.astronautportfolio.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import com.example.astronautportfolio.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBar(modifier: Modifier = Modifier) {
    TopAppBar(
        navigationIcon = {
                         IconButton(onClick = { /*TODO*/ }) {
                             Icon(imageVector = Icons.Default.Star, contentDescription = "Menu Icon")
                         }
        },
        title = {
            Text(text = "Home", fontWeight = FontWeight.Bold)
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(dimensionResource(id = R.dimen.padding_small))
        )
    )
}