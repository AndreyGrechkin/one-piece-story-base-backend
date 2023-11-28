package com.one_piece_story_base.domain.local

import com.one_piece_story_base.data.model.IslandDTO
import com.one_piece_story_base.data.model.IslandTransitDTO
import com.one_piece_story_base.data.model.PersonageIslandDTO

interface IslandLocalDataSource {
    fun fetchIsland(): List<IslandDTO>

    fun fetchPersonageIsland(placeId: Int): List<PersonageIslandDTO>

    fun fetchIslandTransit(placeId: Int): List<IslandTransitDTO>
}