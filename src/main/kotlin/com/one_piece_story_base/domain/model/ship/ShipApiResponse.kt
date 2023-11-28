package com.one_piece_story_base.domain.model.ship

import kotlinx.serialization.Serializable

@Serializable
data class ShipApiResponse(
    val response: List<ShipResponse>
)

@Serializable
data class ShipResponse(
    val id: Int,
    val bandId: Int,
    val mangaId: Int,
    val nameShip: String?,
    val description: String?,
    val oldShip: Int?,
    val nameJp: String?,
    val transcriptionJp: String?,
    val image: String?,
)
