package com.one_piece_story_base.domain.controller

import com.one_piece_story_base.data.model.toResponse
import com.one_piece_story_base.domain.local.IslandLocalDataSource
import com.one_piece_story_base.domain.model.island.IslandApiResponse
import com.one_piece_story_base.domain.model.island.IslandTransitResponse
import com.one_piece_story_base.domain.model.island.PersonageIslandResponse
import com.one_piece_story_base.routing.repository.IslandController

class IslandControllerImpl(
    private val dao: IslandLocalDataSource
):IslandController {
    override suspend fun getIsland(): IslandApiResponse {
        val  daoIsland = dao.fetchIsland()
        return IslandApiResponse(response = daoIsland.map { it.toResponse() })
    }

    override suspend fun getPersonageIsland(placeId: Int): PersonageIslandResponse {
        val daoPersonage = dao.fetchPersonageIsland(placeId)
        return PersonageIslandResponse(response = daoPersonage.map { it.toResponse() })
    }

    override suspend fun getIslandTransit(placeId: Int): IslandTransitResponse {
       val daoTransit = dao.fetchIslandTransit(placeId)
        return IslandTransitResponse(response = daoTransit.map { it.toResponse() })
    }
}