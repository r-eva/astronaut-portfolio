package com.example.astronautportfolio.ui.screens.home

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.astronautportfolio.R
import com.example.astronautportfolio.model.overview.Result
import com.example.astronautportfolio.ui.components.BasicInfoCol
import com.example.astronautportfolio.ui.components.ImageThumbnail

@Composable
fun AstronautItem (
    astronauts: Result,
    modifier: Modifier = Modifier
) {
    print("data astronaut: $astronauts.profileImageThumbnail")
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    ){
                ImageThumbnail(data = astronauts.profileImageThumbnail)
                BasicInfoCol(name = astronauts.name, age = astronauts.age)
            }
        }


    }
}