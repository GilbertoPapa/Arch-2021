package com.gilbertopapa.network.domain.usecase

import androidx.paging.PagedList
import com.gilbertopapa.network.domain.FavoriteGames
import com.gilbertopapa.network.domain.Games
import com.gilbertopapa.network.domain.repository.IGamesRepository
import com.gilbertopapa.network.source.remote.local.Resource
import kotlinx.coroutines.flow.Flow

class GamesUseCase(private val iGamesRepository: IGamesRepository) : IGamesUseCase {
    override fun getGames(): Flow<Resource<List<Games>>> = iGamesRepository.getGames()

    override fun getDetailGame(gamesId: Int): Flow<Resource<Games>> =
        iGamesRepository.getDetailGame(gamesId)

    override fun getSearchGames(search: String): Flow<Resource<List<Games>>> =
        iGamesRepository.getSearchGames(search)

    override fun getListGamesFavorites(): Flow<PagedList<Games>> =
        iGamesRepository.getListGamesFavorites()

    override fun getGamesFavorite(favoriteGamesId: Int): Flow<FavoriteGames?> =
        iGamesRepository.getGamesFavorite(favoriteGamesId)

    override suspend fun insertFavoriteGame(favoriteGamesId: Int) =
        iGamesRepository.insertFavoriteGame(favoriteGamesId)

    override suspend fun deleteFavoriteGame(favoriteGamesId: Int) =
        iGamesRepository.deleteFavoriteGame(favoriteGamesId)
}