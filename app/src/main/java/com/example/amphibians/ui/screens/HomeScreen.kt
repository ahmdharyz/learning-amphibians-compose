package com.example.amphibians.ui.screens

import com.example.amphibians.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.amphibians.network.Amphibian

@Composable
fun HomeScreen(amphibiansUiState: AmphibiansUiState, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        when(amphibiansUiState) {
            is AmphibiansUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
            is AmphibiansUiState.Success -> ResultScreen(
                amphibiansUiState.amphibians, modifier = modifier
            )
            is AmphibiansUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
        }
    }
}

@Composable
fun ResultScreen(amphibians: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = amphibians)
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Image(
            modifier = modifier.size(200.dp),
            painter = painterResource(id = R.drawable.loading_img),
            contentDescription = stringResource(R.string.loading)
        )
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = stringResource(R.string.loading_failed)
        )
    }
}