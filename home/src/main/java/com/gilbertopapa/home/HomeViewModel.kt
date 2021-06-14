package com.gilbertopapa.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.gilbertopapa.network.domain.usecase.IGamesUseCase

class HomeViewModel(iBlownUseCase: IGamesUseCase) : ViewModel() {
    val games = iBlownUseCase.getGames().asLiveData()
}