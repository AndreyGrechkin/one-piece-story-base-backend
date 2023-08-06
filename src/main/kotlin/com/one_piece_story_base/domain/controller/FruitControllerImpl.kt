package com.one_piece_story_base.domain.controller

import com.one_piece_story_base.data.model.toResponse
import com.one_piece_story_base.domain.local.FruitLocalDataSource
import com.one_piece_story_base.domain.model.fruit.FruitApiResponse
import com.one_piece_story_base.routing.repository.FruitController

class FruitControllerImpl(
    private val dao: FruitLocalDataSource
): FruitController {
    override suspend fun getFruitByPlace(placeId: Int): FruitApiResponse {
        val fruit = dao.fetchFruitByPlace(placeId).map { it.toResponse() }
        return FruitApiResponse(response = fruit)
    }
}