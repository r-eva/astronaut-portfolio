package com.example.astronautportfolio.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.astronautportfolio.R
import com.example.astronautportfolio.ui.theme.AstronautPortfolioTheme

@Composable
fun ImageThumbnail(data: String?, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(data)
            .crossfade(true)
            .build(),
        contentDescription = stringResource(id = R.string.astronauts_photo),
        modifier = modifier
            .size(dimensionResource(id = R.dimen.thumbnail_image_size))
            .padding(dimensionResource(id = R.dimen.padding_small))
            .clip(RoundedCornerShape(50)),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun ImageThumbnailPreview() {
    AstronautPortfolioTheme() {
        ImageThumbnail(data = "https://spacelaunchnow-prod-east.nyc3.digitaloceanspaces.com/media/astronaut_images/thomas_pesquet_thumbnail_20220911033657.jpeg")
    }
}