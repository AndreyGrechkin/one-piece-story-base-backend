package com.one_piece_story_base.routing.repository

import com.one_piece_story_base.domain.model.fruit.FruitApiResponse

interface FruitController {
    suspend fun getFruitByPlace(placeId: Int): FruitApiResponse
}