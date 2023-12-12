package com.one_piece_story_base.domain.model.personage

import kotlinx.serialization.Serializable

@Serializable
data class PersonageApiResponse(
    val response: List<PersonageResponse>,
)

@Serializable
data class PersonageResponse(
    val id: Int,
    val mangaId: Int,
    val placeId: Int,
    val name: String,
    val nameJp: String?,
    val transcriptionJp: String?,
    val avatar: String?,
)
