package com.one_piece_story_base.domain.model.personage

import com.one_piece_story_base.domain.model.band.BandResponse
import kotlinx.serialization.Serializable

@Serializable
data class PersonageListApiResponse(
    val response: List<PersonageListResponse>,
)

@Serializable
data class PersonageListResponse(
    val id: Int,
    val mangaId: Int,
    val placeId: Int,
    val name: String,
    val nameJp: String?,
    val transcriptionJp: String?,
    val avatar: String?,
    val description: List<PersonageDescriptionResponse>,
    val band: List<BandResponse>,
)
