package com.one_piece_story_base.domain.model.personage

import kotlinx.serialization.Serializable

@Serializable
data class PersonageSkillApiResponse(
    val response: List<PersonageSkillResponse>
)

@Serializable
data class PersonageSkillResponse(
    val id: Int,
    val personageId: Int,
    val mangaId: Int,
    val nameSkill: String,
    val description: String?,
    val nameJp: String?,
    val transcriptionJp: String?,
)
