package com.example.astronautportfolio.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.astronautportfolio.data.mappers.AstronautMapper
import com.example.astronautportfolio.data.repository.AstronautRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: AstronautRepository
): ViewModel() {
    var astronautPagingFlow = repository.provideAstronautPager().cachedIn(viewModelScope)
}