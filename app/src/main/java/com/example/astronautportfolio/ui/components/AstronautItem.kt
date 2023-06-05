package com.example.astronautportfolio.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.astronautportfolio.R
import com.example.astronautportfolio.model.overview.Astronaut
import com.example.astronautportfolio.ui.components.navigation.Screen

@Composable
fun AstronautItem (
    navController: NavController,
    astronauts: Astronaut,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "astronaut",
                    value = astronauts
                )
                navController.navigate(Screen.DetailScreen.withArgs(astronauts.id))
            }
            .background(MaterialTheme.colorScheme.background),
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.padding_small)),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                .background(MaterialTheme.colorScheme.surface)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    ){
                ImageThumbnail(data = astronauts.profileImageThumbnail)
                BasicInfoCol(name = astronauts.name, age = astronauts.age)
                Spacer(Modifier.weight(1f))
                ArrowDownIcon(expanded = expanded, onClick = { expanded = !expanded })
            }
            if (expanded) {
                AdditionalInfo(nationality = astronauts.nationality, status = astronauts.status.name)
            }
        }
    }
}

