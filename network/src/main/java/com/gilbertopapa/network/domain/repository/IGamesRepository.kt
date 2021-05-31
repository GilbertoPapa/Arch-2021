package com.gilbertopapa.network.domain.repository

import androidx.paging.PagedList
import com.gilbertopapa.network.domain.model.FavoriteGames
import com.gilbertopapa.network.domain.model.Games
import com.gilbertopapa.network.local.Resource
import kotlinx.coroutines.flow.Flow

interface IGamesRepository {
    fun getGames(): Flow<Resource<List<Games>>>
    fun getDetailGame(gamesId: Int): Flow<Resource<Games>>
    fun getSearchGames(search: String): Flow<Resource<List<Games>>>
    fun getListGamesFavorites(): Flow<PagedList<Games>>
    fun getGamesFavorite(favoriteGamesId: Int): Flow<FavoriteGames?>
    suspend fun insertFavoriteGame(favoriteGamesId: Int)
    suspend fun deleteFavoriteGame(favoriteGamesId: Int)
}