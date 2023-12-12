package com.one_piece_story_base.domain.controller

import com.one_piece_story_base.data.model.toResponse
import com.one_piece_story_base.domain.local.BondLocalDataSource
import com.one_piece_story_base.domain.model.bond.BondApiResponse
import com.one_piece_story_base.routing.repository.BondController

class BondControllerImpl(
    private val dao: BondLocalDataSource,
) : BondController {
    override suspend fun getBondByPlace(placeId: Int): BondApiResponse {
        val bond = dao.fetchBondByPlace(placeId).map { it.toResponse() }
        return BondApiResponse(response = bond)
    }
}