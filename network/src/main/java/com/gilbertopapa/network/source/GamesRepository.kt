package com.gilbertopapa.network.source

import androidx.lifecycle.asFlow
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.gilbertopapa.network.domain.model.FavoriteGames
import com.gilbertopapa.network.domain.model.Games
import com.gilbertopapa.network.domain.repository.IGamesRepository
import com.gilbertopapa.network.local.Resource
import com.gilbertopapa.network.local.entity.FavoriteGamesEntity
import com.gilbertopapa.network.utils.DataMapper
import com.gilbertopapa.network.utils.networkBoundResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GamesRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : IGamesRepository {

    override fun getGames(): Flow<Resource<List<Games>>> = networkBoundResource(
        {
            localDataSource.getGames().map {
                DataMapper.mapListGamesEntitiesToDomain(it)
            }
        },
        { remoteDataSource.getGames() },
        {
            val gamesList = DataMapper.mapListGamesResponseToEntities(it.results)
            localDataSource.insertGames(gamesList)
        }
    )

    override fun getDetailGame(gamesId: Int): Flow<Resource<Games>> = networkBoundResource(
        {
            localDataSource.getDetailGames(gamesId).map {
                DataMapper.mapGamesEntitiesToDomain(it)
            }
        },
        { remoteDataSource.getDetailGames(gamesId) },
        {
            val gamesList = DataMapper.mapGamesResponseToEntities(it)
            localDataSource.updateDetailGames(gamesList)
        }
    )


    override fun getSearchGames(search: String): Flow<Resource<List<Games>>> = networkBoundResource(
        {
            localDataSource.getSearchGames(search).map {
                DataMapper.mapListGamesEntitiesToDomain(it)
            }
        },
        { remoteDataSource.getSearchGames(search) },
        {
            val gamesList = DataMapper.mapListGamesResponseToEntities(it.results)
            localDataSource.insertGames(gamesList)
        }
    )

    override fun getListGamesFavorites(): Flow<PagedList<Games>> = LivePagedListBuilder(
        localDataSource.getListGamesFavorites().map { DataMapper.mapGamesEntitiesToDomain(it) },
        PagedList.Config.Builder().setEnablePlaceholders(false).setInitialLoadSizeHint(20)
            .setPageSize(20).build()
    ).build().asFlow()


    override fun getGamesFavorite(favoriteGamesId: Int): Flow<FavoriteGames?> =
        localDataSource.getGamesFavorite(favoriteGamesId).map {
            DataMapper.mapFavoriteGamesEntitiesToDomain(it)
        }

    override suspend fun insertFavoriteGame(favoriteGamesId: Int) =
        localDataSource.insertFavoriteGame(FavoriteGamesEntity(favoriteGamesId))

    override suspend fun deleteFavoriteGame(favoriteGamesId: Int) =
        localDataSource.deleteFavoriteGame(FavoriteGamesEntity(favoriteGamesId))
}