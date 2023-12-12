package com.one_piece_story_base.domain.model.band

import kotlinx.serialization.Serializable

@Serializable
data class BandDescriptionApiResponse(
    val response: List<BandDescriptionResponse>,
)

@Serializable
data class BandDescriptionResponse(
    val id: Int,
    val bandId: Int,
    val mangaId: Int,
    val description: String?,
)
