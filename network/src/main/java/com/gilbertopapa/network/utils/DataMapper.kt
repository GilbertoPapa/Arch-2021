package com.gilbertopapa.network.utils

import com.gilbertopapa.network.domain.model.FavoriteGames
import com.gilbertopapa.network.domain.model.Games
import com.gilbertopapa.network.local.entity.FavoriteGamesEntity
import com.gilbertopapa.network.local.entity.GamesEntity
import com.gilbertopapa.network.response.DetailGamesResponse
import com.gilbertopapa.network.response.GamesResponse


object DataMapper {

    fun mapListGamesResponseToEntities(input: List<GamesResponse>): List<GamesEntity> = input.map {
        GamesEntity(
            suggestionsCount = it.suggestionsCount,
            rating = it.rating,
            id = it.id,
            backgroundImage = it.backgroundImage,
            description = null,
            reviewsTextCount = null,
            name = it.name,
            playtime = it.playtime,
            ratingTop = null,
            released = it.released,
            website = null
        )
    }

    fun mapListGamesEntitiesToDomain(input: List<GamesEntity>): List<Games> = input.map {
        Games(
            suggestionsCount = it.suggestionsCount,
            rating = it.rating,
            id = it.id,
            backgroundImage = it.backgroundImage,
            description = it.description,
            reviewsTextCount = it.reviewsTextCount,
            name = it.name,
            playtime = it.playtime,
            ratingTop = it.ratingTop,
            released = it.released,
            website = it.website
        )
    }

    fun mapGamesResponseToEntities(input: DetailGamesResponse): GamesEntity = GamesEntity(
        suggestionsCount = input.suggestionsCount,
        rating = input.rating,
        id = input.id,
        backgroundImage = input.backgroundImage,
        description = input.description,
        reviewsTextCount = input.reviewsTextCount,
        name = input.name,
        playtime = input.playtime,
        ratingTop = input.ratingTop,
        released = input.released,
        website = input.website
    )

    fun mapGamesEntitiesToDomain(input: GamesEntity): Games = Games(
        suggestionsCount = input.suggestionsCount,
        rating = input.rating,
        id = input.id,
        backgroundImage = input.backgroundImage,
        description = input.description,
        reviewsTextCount = input.reviewsTextCount,
        name = input.name,
        playtime = input.playtime,
        ratingTop = input.ratingTop,
        released = input.released,
        website = input.website
    )

    fun mapFavoriteGamesEntitiesToDomain(input: FavoriteGamesEntity?): FavoriteGames? {
        return if (input != null) {
            FavoriteGames(
                id = input.id
            )
        } else {
            null
        }

    }
}