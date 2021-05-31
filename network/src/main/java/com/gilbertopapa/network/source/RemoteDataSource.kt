package com.gilbertopapa.network.source

import com.gilbertopapa.network.api.ApiService
import com.gilbertopapa.network.source.BaseDataSource
import kotlinx.coroutines.CoroutineDispatcher

class RemoteDataSource(
    private val apiService: ApiService,
    private val dispatcher: CoroutineDispatcher,
    private val key: String
) : BaseDataSource() {

    suspend fun getGames() = getResult({ apiService.getGames(key) }, dispatcher)

    suspend fun getDetailGames(gamesId: Int) =
        getResult({ apiService.getDetailGames(gamesId, key) }, dispatcher)

    suspend fun getSearchGames(search: String) =
        getResult({ apiService.getSearchGames(key, search, true) }, dispatcher)
}