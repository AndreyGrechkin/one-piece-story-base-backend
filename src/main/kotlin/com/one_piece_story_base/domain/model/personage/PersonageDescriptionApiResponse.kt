package com.one_piece_story_base.domain.model.personage

import kotlinx.serialization.Serializable

@Serializable
data class PersonageDescriptionApiResponse(
    val response: List<PersonageDescriptionResponse>
)

@Serializable
data class PersonageDescriptionResponse(
    val id: Int,
    val personageId: Int,
    val mangaId: Int,
    val description: String?,
    val image: String?,
    val personageType: String?,
    val surname: String?,
    val fruitId: Int?,
    val career: String?,
)
