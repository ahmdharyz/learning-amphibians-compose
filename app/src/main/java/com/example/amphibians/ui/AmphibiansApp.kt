package com.example.amphibians.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.R
import com.example.amphibians.ui.screens.AmphibiansViewModel
import com.example.amphibians.ui.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(R.string.app_name),
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    top = 8.dp,
                    end = 8.dp
                )
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val amphibiansViewModel: AmphibiansViewModel =
                viewModel(factory = AmphibiansViewModel.Factory)

            HomeScreen(
                amphibiansUiState = amphibiansViewModel.amphibiansUiState,
                modifier = Modifier,
                contentPadding = it
            )
        }
    }
}