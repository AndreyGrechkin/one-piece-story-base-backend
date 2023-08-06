package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.personage.PersonageDescriptionResponse
import org.jetbrains.exposed.sql.Table

object PersonageDescriptionTable: Table(name = "personage_description") {
    val id = integer("id")
    val personageId = integer("personage_id").references(PersonageTable.id)
    val mangaId = integer("manga_id").references(MangaTable.id)
    val description = text("description").nullable()
    val image = text("image").nullable()
    val personageType = varchar("personage_type", 50).nullable()
    val surname = varchar("surname", 50).nullable()
    val fruit_id = integer("fruit_id").references(FruitTable.id).nullable()
    val career = varchar("career", 50).nullable()
}

data class PersonageDescriptionDTO(
    val id: Int,
    val personageId: Int,
    val mangaId: Int,
    val description: String?,
    val image: String?,
    val personageType: String?,
    val surname: String?,
    val fruitId: Int?,
    val career: String?,
)

fun PersonageDescriptionDTO.toResponse() = PersonageDescriptionResponse(
    id = id,
    personageId = personageId,
    mangaId = mangaId,
    description = description,
    image = image,
    personageType = personageType,
    surname = surname,
    fruitId = fruitId,
    career = career
)

