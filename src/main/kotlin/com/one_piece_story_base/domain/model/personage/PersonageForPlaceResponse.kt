package com.one_piece_story_base.domain.model.personage

import kotlinx.serialization.Serializable

@Serializable
data class PersonageForPlaceResponse(
    val id: Int,
    val mangaId: Int,
    val placeId: Int,
    val name: String,
    val nameJp: String?,
    val transcriptionJp: String?,
    val avatar: String?,
    val image: String?,
    val fruit: String?
)
