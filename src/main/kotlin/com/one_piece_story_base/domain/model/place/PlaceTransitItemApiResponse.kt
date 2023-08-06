package com.one_piece_story_base.domain.model.place

import kotlinx.serialization.Serializable

@Serializable
data class  PlaceTransitItemApiResponse(
    val response: List<PlaceTransitItemResponse>
)

@Serializable
data class PlaceTransitItemResponse(
    val id: Int,
    val mangaId: Int,
    val placeId: Int,
    val personageId: Int,
    val outItemId: Int?,
    val inItemId: Int?
)