package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.personage.PersonageSkillResponse
import org.jetbrains.exposed.sql.Table

object PersonageSkillTable: Table(name = "personage_skill") {
    val id = integer("id")
    val personageId = integer("personage_id").references(PersonageTable.id)
    val mangaId = integer("manga_id").references(MangaTable.id)
    val nameSkill = varchar("name_skill", 50)
    val description = text("description").nullable()
    val nameJp = varchar("name_jp", 50).nullable()
    val transcriptionJp = varchar("transcription_jp_name", 50).nullable()
}

data class PersonageSkillDTO(
    val id: Int,
    val personageId: Int,
    val mangaId: Int,
    val nameSkill: String,
    val description: String?,
    val nameJp: String?,
    val transcriptionJp: String?,
)

fun PersonageSkillDTO.toResponse() = PersonageSkillResponse(
    id = id,
    personageId = personageId,
    mangaId = mangaId,
    nameSkill = nameSkill,
    description = description,
    nameJp = nameJp,
    transcriptionJp = transcriptionJp
)