package com.one_piece_story_base.domain.model.island

import kotlinx.serialization.Serializable


@Serializable
data class IslandApiResponse(
    val response: List<IslandResponse>,
)

@Serializable
class IslandResponse(
    val id: Int,
    val name: String?,
    val nameImage: String,
    val posX: Double,
    val posY: Double,
    val placeId: Int?,
)