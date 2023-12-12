package com.one_piece_story_base.routing.repository

import com.one_piece_story_base.domain.model.band.BandApiResponse
import com.one_piece_story_base.domain.model.band.BandDescriptionApiResponse
import com.one_piece_story_base.domain.model.band.BandPersonageApiResponse

interface BandController {
    suspend fun getBandByPlace(placeId: Int): BandApiResponse
    suspend fun getBandDescriptionByPlace(placeId: Int): BandDescriptionApiResponse
    suspend fun getBandPersonageByPlace(placeId: Int): BandPersonageApiResponse
}