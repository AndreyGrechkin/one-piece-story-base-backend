package com.one_piece_story_base.routing.repository

import com.one_piece_story_base.domain.model.ship.ShipApiResponse

interface ShipController {
    suspend fun getShipByPlace(placeId: Int): ShipApiResponse
}