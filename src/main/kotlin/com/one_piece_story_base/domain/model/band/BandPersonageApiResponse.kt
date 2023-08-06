package com.one_piece_story_base.domain.model.band

import kotlinx.serialization.Serializable

@Serializable
data class BandPersonageApiResponse(
    val response: List<BandPersonageResponse>
)

@Serializable
data class BandPersonageResponse(
    val id: Int,
    val personageId: Int,
    val bandId: Int,
    val mangaId: Int,
    val career: String?,
    val oldPersonage: Boolean
)