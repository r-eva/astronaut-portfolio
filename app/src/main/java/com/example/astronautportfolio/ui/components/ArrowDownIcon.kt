package com.example.astronautportfolio.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.astronautportfolio.R

@Composable
fun ArrowDownIcon(
    expanded: Boolean,
    onClick: () -> Unit,
){
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            tint = MaterialTheme.colorScheme.secondary,
            contentDescription = stringResource(id = R.string.expand_button_content_description)
        )
    }
}