package com.one_piece_story_base.domain.controller

import com.one_piece_story_base.data.model.toResponse
import com.one_piece_story_base.domain.local.BandLocalDataSource
import com.one_piece_story_base.domain.model.band.BandApiResponse
import com.one_piece_story_base.domain.model.band.BandDescriptionApiResponse
import com.one_piece_story_base.domain.model.band.BandPersonageApiResponse
import com.one_piece_story_base.routing.repository.BandController

class BandControllerImpl(
    private val dao: BandLocalDataSource,
) : BandController {
    override suspend fun getBandByPlace(placeId: Int): BandApiResponse {
        val band = dao.fetchBandByPlaceId(placeId).map { it.toResponse() }
        return BandApiResponse(response = band)
    }

    override suspend fun getBandDescriptionByPlace(placeId: Int): BandDescriptionApiResponse {
        val bandDescription = dao.fetchBandDescriptionByPlace(placeId).map { it.toResponse() }
        return BandDescriptionApiResponse(response = bandDescription)
    }

    override suspend fun getBandPersonageByPlace(placeId: Int): BandPersonageApiResponse {
        val bandPersonage = dao.fetchBandPersonageByPlace(placeId).map { it.toResponse() }
        return BandPersonageApiResponse(response = bandPersonage)
    }
}