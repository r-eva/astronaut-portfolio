package com.example.astronautportfolio.ui.screens.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.astronautportfolio.data.repository.AstronautRepository
import com.example.astronautportfolio.model.detail.AstronautDetail
import kotlinx.coroutines.launch

class DetailViewModel (
    private val repository: AstronautRepository = AstronautRepository()
        ): ViewModel(){

    private val _astronautDetailsState = mutableStateOf<AstronautDetail?>(null)
    val astronautDetailState: State<AstronautDetail?>
        get() = _astronautDetailsState

    private val _isLoading = mutableStateOf(false)
    val isLoading: Boolean
        get() = _isLoading.value

    private val _error = mutableStateOf("")
    val error: String
        get() = _error.value

    fun getAstronautDetailById(id: Int) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val astronaut = repository.getAstronautById(id)
                _astronautDetailsState.value = astronaut
            } catch (e: Exception) {
                _error.value = "Error retrieving astronaut details: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}