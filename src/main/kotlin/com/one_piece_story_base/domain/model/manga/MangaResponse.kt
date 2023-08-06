package com.one_piece_story_base.domain.model.manga

import kotlinx.serialization.Serializable

@Serializable
data class MangaApiResponse(
    val manges: List<MangaResponse>
)

@Serializable
data class MangaResponse(
    val id: Int,
    val volume: String?,
    val chapter: String?,
    val animeType: String?,
    val animeSeries: String?,
    val description: String?,
    val placeId: Int
)
