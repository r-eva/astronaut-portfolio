package com.example.astronautportfolio.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.example.astronautportfolio.R
import com.example.astronautportfolio.model.overview.Result
import com.example.astronautportfolio.ui.components.AstronautItem

@Composable
fun HomeScreen(
    astronauts: LazyPagingItems<Result>
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = astronauts.loadState) {
        if(astronauts.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (astronauts.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if(astronauts.loadState.refresh is LoadState.Loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {
                items(
                    count = astronauts.itemCount,
                    key = astronauts.itemKey(),
                    contentType = astronauts.itemContentType(
                        )
                ) { index ->
                    val item = astronauts[index]
                    if (item != null) {
                        AstronautItem(
                            astronauts = item, modifier = Modifier.padding(
                                dimensionResource(id = R.dimen.padding_small)
                            )
                        )
                    }
                            }
                            item {
                                if(astronauts.loadState.append is LoadState.Loading) {
                                    CircularProgressIndicator()
                                }
                            }
                        }
                    }
                }
}