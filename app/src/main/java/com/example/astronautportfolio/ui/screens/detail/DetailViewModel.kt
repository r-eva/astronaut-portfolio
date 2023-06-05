package com.example.astronautportfolio.ui.screens.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.astronautportfolio.data.repository.AstronautDetailRepository
import com.example.astronautportfolio.data.repository.AstronautRepository
import com.example.astronautportfolio.model.detail.AstronautDetail
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.astronautportfolio.model.overview.Astronaut
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: AstronautDetailRepository,
): ViewModel() {

    private val _astronautDetailState = mutableStateOf<AstronautDetail?>(null)
    val astronautDetailState: State<AstronautDetail?> get() = _astronautDetailState

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
                val astronaut = repository.getAstronautDetail(id)
                println("astronaut get from repo: $astronaut")
                _astronautDetailState.value = astronaut
            } catch (e: Exception) {
                _error.value = "Error retrieving astronaut details: ${e.message}"
                _astronautDetailState.value = null
            } finally {
                _isLoading.value = false
            }
        }
    }

}