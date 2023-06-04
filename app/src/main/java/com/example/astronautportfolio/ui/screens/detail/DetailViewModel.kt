package com.example.astronautportfolio.ui.screens.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.astronautportfolio.data.repository.AstronautRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.astronautportfolio.model.Astronaut
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: AstronautRepository,
): ViewModel() {

    private val _astronautDetailState = mutableStateOf<Astronaut?>(null)
    val astronautDetailState: State<Astronaut?> get() = _astronautDetailState

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
                _astronautDetailState.value = astronaut
            } catch (e: Exception) {
                _error.value = "Error retrieving astronaut details: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

}