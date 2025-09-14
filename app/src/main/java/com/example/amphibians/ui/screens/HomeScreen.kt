package com.example.amphibians.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.amphibians.network.Amphibian

@Composable
fun HomeScreen(amphibiansUiState: String, modifier: Modifier = Modifier) {
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