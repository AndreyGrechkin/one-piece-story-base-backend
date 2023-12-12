package com.one_piece_story_base.domain.controller

import com.one_piece_story_base.data.model.toResponse
import com.one_piece_story_base.domain.local.ShipLocalDataSource
import com.one_piece_story_base.domain.model.ship.ShipApiResponse
import com.one_piece_story_base.routing.repository.ShipController

class ShipControllerImpl(
    private val dao: ShipLocalDataSource,
) : ShipController {
    override suspend fun getShipByPlace(placeId: Int): ShipApiResponse {
        val ship = dao.fetchShipByPlace(placeId).map { it.toResponse() }
        return ShipApiResponse(response = ship)
    }
}