package com.one_piece_story_base.domain.model.band

import kotlinx.serialization.Serializable

@Serializable
data class BandApiResponse(
    val response: List<BandResponse>,
)

@Serializable
data class BandResponse(
    val id: Int,
    val mangaId: Int,
    val nameBand: String,
    val image: String?,
    val bandType: String?,
    val nameJp: String?,
    val transcriptionJp: String?,
)
