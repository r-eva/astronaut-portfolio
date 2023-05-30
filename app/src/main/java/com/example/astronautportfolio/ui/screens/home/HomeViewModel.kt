package com.example.astronautportfolio.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.astronautportfolio.data.local.entity.overview.ResultEntity
import com.example.astronautportfolio.data.mappers.AstronautOverviewMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    pager: Pager<Int, ResultEntity>
): ViewModel() {
    var astronautPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map {
                AstronautOverviewMapper().mapResultEntityToResult(it)
            }
        }
        .cachedIn(viewModelScope)
}