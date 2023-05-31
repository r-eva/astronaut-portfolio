package com.example.astronautportfolio.ui.screens.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.astronautportfolio.data.repository.AstronautRepository
import com.example.astronautportfolio.model.detail.AstronautDetail
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.astronautportfolio.AstronautsApp
import com.example.astronautportfolio.data.repository.AstronautDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel

/*class DetailViewModel (
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
}*/
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: AstronautDetailRepository,
): ViewModel() {

    private val _astronautDetailState = mutableStateOf<AstronautDetail<Any?>?>(null)
    val astronautDetailState: State<AstronautDetail<Any?>?> get() = _astronautDetailState

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
                println("astronaut ViewModel: $astronaut")
            } catch (e: Exception) {
                _error.value = "Error retrieving astronaut details: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

}