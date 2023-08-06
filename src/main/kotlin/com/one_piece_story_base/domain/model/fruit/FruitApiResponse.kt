package com.one_piece_story_base.domain.model.fruit

import kotlinx.serialization.Serializable

@Serializable
data class FruitApiResponse (
    val response: List<FruitResponse>
)

@Serializable
data class FruitResponse (
    val id: Int,
    val mangaId: Int,
    val nameFruit: String,
    val fruitType: String?,
    val image: String?,
    val description: String?,
    val nameJp: String?,
    val transcriptionJp: String?,
)