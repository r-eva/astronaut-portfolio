package com.example.astronautportfolio.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.astronautportfolio.R

@Composable
fun ProfileImage (image: String?, modifier: Modifier = Modifier){
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(image)
            .crossfade(true)
            .build(),
        contentDescription = stringResource(id = R.string.astronauts_detail_photo),
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.profile_image_size))
            .padding(dimensionResource(id = R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop
    )
}