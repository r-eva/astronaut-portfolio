package com.example.astronautportfolio.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import com.example.astronautportfolio.R
import com.example.astronautportfolio.model.overview.Result
import com.example.astronautportfolio.ui.components.BasicInfoCol
import com.example.astronautportfolio.ui.components.ImageThumbnail
import com.example.astronautportfolio.ui.components.navigation.Screen

@Composable
fun AstronautItem (
    navController: NavController,
    astronauts: Result,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.clickable {
            navController.currentBackStackEntry?.savedStateHandle?.set(
                key = "astronaut",
                value = astronauts
            )
            navController.navigate(Screen.DetailScreen.withArgs(astronauts.id))
        }
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