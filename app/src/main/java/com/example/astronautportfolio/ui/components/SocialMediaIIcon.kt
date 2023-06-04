package com.example.astronautportfolio.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.astronautportfolio.R

@Composable
fun ArrowDownIcon(
    instagram: String,
    twitter: String,
    wiki: String
){
    Icon(
        imageVector = Icons.Default.Star,
        tint = MaterialTheme.colorScheme.secondary,
        contentDescription = stringResource(id = R.string.expand_button_content_description)
    )
}