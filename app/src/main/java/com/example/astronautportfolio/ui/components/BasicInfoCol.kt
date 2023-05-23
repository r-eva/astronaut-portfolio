package com.example.astronautportfolio.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BasicInfoCol(name: String, age: Int, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = name,
            modifier = modifier.padding(top = 8.dp)
        )
        Text(
            text = "Age: $age"
        )
    }
}