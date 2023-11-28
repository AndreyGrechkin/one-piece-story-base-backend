package com.one_piece_story_base.routing.repository

import com.one_piece_story_base.domain.model.island.IslandApiResponse
import com.one_piece_story_base.domain.model.island.IslandTransitResponse
import com.one_piece_story_base.domain.model.island.PersonageIslandResponse

interface IslandController {

    suspend fun getIsland(): IslandApiResponse

    suspend fun getPersonageIsland(placeId: Int): PersonageIslandResponse

    suspend fun getIslandTransit(placeId: Int): IslandTransitResponse
}