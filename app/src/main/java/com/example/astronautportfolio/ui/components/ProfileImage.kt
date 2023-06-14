package com.example.astronautportfolio.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
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
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.astronautportfolio.R
import com.example.astronautportfolio.ui.theme.AstronautPortfolioTheme

@Composable
fun ProfileImage (image: String?, modifier: Modifier = Modifier){
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(image)
            .crossfade(true)
            .build(),
        placeholder = DebugPlaceholder(debugPreview = R.drawable.astronaut_profile_placeholder),
        contentDescription = stringResource(id = R.string.astronauts_detail_photo),
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.profile_image_size))
            .padding(dimensionResource(id = R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop
    )
}


@Preview
@Composable
fun ProfileImagePreview() {
    AstronautPortfolioTheme() {
        ProfileImage(image = "https://spacelaunchnow-prod-east.nyc3.digitaloceanspaces.com/media/astronaut_images/thomas_pesquet_thumbnail_20220911033657.jpeg")
    }
}