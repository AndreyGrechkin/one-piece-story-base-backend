package com.one_piece_story_base.domain.local

import com.one_piece_story_base.data.model.FruitDTO

interface FruitLocalDataSource {
    fun fetchFruitByPlace(placeId: Int): List<FruitDTO>
}