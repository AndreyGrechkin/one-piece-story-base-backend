package com.one_piece_story_base.domain.local

import com.one_piece_story_base.data.model.ShipDTO

interface ShipLocalDataSource {
    fun fetchShipByPlace(placeId: Int) : List<ShipDTO>
}