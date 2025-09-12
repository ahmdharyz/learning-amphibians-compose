package com.example.amphibians.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.network.Amphibian
import com.example.amphibians.network.AmphibiansApi
import kotlinx.coroutines.launch
import retrofit2.http.GET

sealed interface AmphibiansUiState {
    data class Success(val amphibians: List<Amphibian>) : AmphibiansUiState
    object Error: AmphibiansUiState
    object Loading: AmphibiansUiState
}

class AmphibiansViewModel : ViewModel() {
    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)

    init {
        getAmphibians()
    }

    private fun getAmphibians() {
        viewModelScope.launch {
            val listResult = AmphibiansApi.retrofitService.getAmphibians()
            amphibiansUiState = listResult as AmphibiansUiState
        }
    }

}