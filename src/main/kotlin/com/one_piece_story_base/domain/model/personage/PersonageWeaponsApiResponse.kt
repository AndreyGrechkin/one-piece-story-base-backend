package com.one_piece_story_base.domain.model.personage

import kotlinx.serialization.Serializable

@Serializable
data class PersonageWeaponsApiResponse(
    val response: List<PersonageWeaponsResponse>
)

@Serializable
data class PersonageWeaponsResponse(
    val id: Int,
    val personageId: Int,
    val mangaId: Int,
    val nameWeapons: String?,
    val description: String?,
    val oldWeapon: Boolean
)