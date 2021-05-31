package com.gilbertopapa.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.gilbertopapa.network.domain.usecase.IGamesUseCase

class HomeViewModel(iGamesUseCase: IGamesUseCase) : ViewModel() {
    val games = iGamesUseCase.getGames().asLiveData()
}