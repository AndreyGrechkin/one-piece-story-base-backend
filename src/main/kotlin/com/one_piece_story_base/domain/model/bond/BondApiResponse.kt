package com.one_piece_story_base.domain.model.bond

import kotlinx.serialization.Serializable

@Serializable
data class BondApiResponse(
    val response: List<BondResponse>,
)

@Serializable
data class BondResponse(
    val id: Int,
    val personageId: Int,
    val mangaId: Int,
    val bondPersonageId: Int,
    val description: String?,
    val bondType: String?,
)
