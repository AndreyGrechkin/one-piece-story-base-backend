package com.one_piece_story_base.domain.model.island

import kotlinx.serialization.Serializable

@Serializable
data class PersonageIslandResponse(
    val response: List<PersonageIslandResponseBody>,
)

@Serializable
data class PersonageIslandResponseBody(
    val id: Int,
    val placeId: Int,
    val nameAvatar: String,
    val nameImage: String,
    val posX: Double,
    val posY: Double,
)