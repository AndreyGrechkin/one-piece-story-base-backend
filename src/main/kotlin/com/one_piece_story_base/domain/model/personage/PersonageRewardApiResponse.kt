package com.one_piece_story_base.domain.model.personage

import kotlinx.serialization.Serializable

@Serializable
data class PersonageRewardApiResponse(
    val response: List<PersonageRewardResponse>
)

@Serializable
data class PersonageRewardResponse(
    val id: Int,
    val personageId: Int,
    val mangaId: Int,
    val reward: Int,
    val rewardType: String,
    val image: String?,
)


