package com.one_piece_story_base.domain.model.island

import kotlinx.serialization.Serializable

@Serializable
data class IslandTransitResponse(
    val response: List<IslandTransitResponseBody>,
)

@Serializable
data class IslandTransitResponseBody(
    val id: Int,
    val avatarId: Int,
    val placeId: Int,
    val posX: Double,
    val posY: Double,
)