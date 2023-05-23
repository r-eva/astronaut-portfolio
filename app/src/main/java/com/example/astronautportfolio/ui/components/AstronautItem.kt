package com.example.astronautportfolio.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.astronautportfolio.model.overview.Result
import com.example.astronautportfolio.ui.components.BasicInfoCol

@Composable
fun AstronautItem (
    astronauts: Result,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        BasicInfoCol(name = astronauts.name, age = astronauts.age)
    }
}