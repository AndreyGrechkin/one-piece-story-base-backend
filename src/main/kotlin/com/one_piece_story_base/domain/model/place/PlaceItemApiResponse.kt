package com.one_piece_story_base.domain.model.place

import kotlinx.serialization.Serializable

@Serializable
data class PlaceItemApiResponse(
    val response: List<PlaceItemResponse>,
)

@Serializable
data class PlaceItemResponse(
    val id: Int,
    val placeId: Int,
    val nameItem: String?,
    val nameJp: String?,
    val transcriptionJp: String?,
    val description: String?,
    val image: String?,
    val posX: Double,
    val posY: Double,
)