package com.one_piece_story_base.domain.model.inventory

import kotlinx.serialization.Serializable

@Serializable
data class InventoryApiResponse(
    val response: List<InventoryResponse>,
)

@Serializable
data class InventoryResponse(
    val id: Int,
    val mangaId: Int,
    val placeId: Int,
    val image: String?,
    val description: String?,
    val name: String,
    val nameJp: String?,
    val transcriptionJp: String?,
)
