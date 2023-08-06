package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.personage.PersonageRewardResponse
import org.jetbrains.exposed.sql.Table

object PersonageRewardTable: Table(name = "personage_reward") {
    val id = integer("id")
    val personageId = integer("personage_id").references(PersonageTable.id)
    val mangaId = integer("manga_id").references(MangaTable.id)
    val reward = integer("reward")
    val rewardType = varchar("type_reward", 50)
    val image = text("image").nullable()
}

data class PersonageRewardDTO(
    val id: Int,
    val personageId: Int,
    val mangaId: Int,
    val reward: Int,
    val rewardType: String,
    val image: String?,
)

fun PersonageRewardDTO.toResponse() = PersonageRewardResponse(
    id = id,
    personageId = personageId,
    mangaId = mangaId,
    reward = reward,
    rewardType = rewardType,
    image = image
)