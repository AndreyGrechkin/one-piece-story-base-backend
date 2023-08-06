package com.one_piece_story_base.routing.repository

import com.one_piece_story_base.domain.model.bond.BondApiResponse

interface BondController {
    suspend fun getBondByPlace(placeId: Int): BondApiResponse
}