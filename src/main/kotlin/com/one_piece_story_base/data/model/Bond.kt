package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.bond.BondResponse
import org.jetbrains.exposed.sql.Table

object BondTable: Table(name = "bond") {
    val id = integer("id")
    val personageId = integer("personage_id").references(PersonageTable.id)
    val mangaId = integer("manga_id").references(MangaTable.id)
    val bondPersonageId = integer("bond_personage_id").references(PersonageTable.id)
    val description = text("description").nullable()
    val bondType = varchar("type_bond", 50).nullable()
}

data class BondDTO(
    val id: Int,
    val personageId: Int,
    val mangaId: Int,
    val bondPersonageId: Int,
    val description: String?,
    val bondType: String?
)

fun BondDTO.toResponse() = BondResponse(
    id = id,
    personageId = personageId,
    mangaId = mangaId,
    bondPersonageId = bondPersonageId,
    description = description,
    bondType = bondType
)

