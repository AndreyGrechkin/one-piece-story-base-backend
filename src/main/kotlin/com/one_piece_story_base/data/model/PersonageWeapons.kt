package com.one_piece_story_base.data.model

import com.one_piece_story_base.data.model.PersonageSkillTable.nullable
import com.one_piece_story_base.data.model.PersonageSkillTable.references
import com.one_piece_story_base.domain.model.personage.PersonageWeaponsResponse
import org.jetbrains.exposed.sql.Table

object PersonageWeaponsTable: Table(name = "personage_weapons") {
    val id = integer("id")
    val personageId = integer("personage_id").references(PersonageTable.id)
    val mangaId = integer("manga_id").references(MangaTable.id)
    val nameWeapons = varchar("name_weapons", 50).nullable()
    val description = text("description").nullable()
    val oldWeapon = bool("old_weapon")
 //   val personageDescriptionId = integer("personage_description_id").references(PersonageDescriptionTable.id).nullable()
}

data class PersonageWeaponsDTO(
    val id: Int,
    val personageId: Int,
    val mangaId: Int,
    val nameWeapons: String?,
    val description: String?,
    val oldWeapon: Boolean
)

fun PersonageWeaponsDTO.toResponse() = PersonageWeaponsResponse(
    id = id,
    personageId = personageId,
    mangaId = mangaId,
    nameWeapons = nameWeapons,
    description = description,
    oldWeapon = oldWeapon
)

