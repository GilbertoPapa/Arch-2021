package com.gilbertopapa.arch_2021

import com.gilbertopapa.network.domain.usecase.GamesUseCase
import com.gilbertopapa.network.domain.usecase.IGamesUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<IGamesUseCase> {
        GamesUseCase(get())
    }
}

val viewModelModule = module {
    factory {
        Dispatchers.IO
    }
    viewModel {
        com.gilbertopapa.home.HomeViewModel(get())
    }
//    viewModel {
//        SearchViewModel(get())
//    }
//    viewModel {
//        DetailViewModel(get(), get())
//    }
}