package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.fruit.FruitResponse
import org.jetbrains.exposed.sql.Table

object FruitTable: Table(name = "fruit") {
    val id = integer("id")
    val mangaId = integer("manga_id").references(MangaTable.id)
    val nameFruit = varchar("name_fruit", 50)
    val fruitType = varchar("type_fruit", 50).nullable()
    val image = text("image").nullable()
    val description = text("description").nullable()
    val nameJp = varchar("name_jp", 50).nullable()
    val transcriptionJp = varchar("transcription_jp_name", 40).nullable()
}

data class FruitDTO(
    val id: Int,
    val mangaId: Int,
    val nameFruit: String,
    val fruitType: String?,
    val image: String?,
    val description: String?,
    val nameJp: String?,
    val transcriptionJp: String?,
)

fun FruitDTO.toResponse() = FruitResponse(
    id = id,
    mangaId = mangaId,
    nameFruit = nameFruit,
    fruitType = fruitType,
    image = image,
    description = description,
    nameJp = nameJp,
    transcriptionJp = transcriptionJp
)