package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.inventory.InventoryResponse
import org.jetbrains.exposed.sql.Table

object InventoryTable: Table(name = "inventory") {
    val id = integer("id")
    val mangaId = integer("manga_id").references(MangaTable.id)
    val placeId = integer("place_id").references(PlaceTable.id)
    val image = text("image").nullable()
    val description = text("description").nullable()
    val name = varchar("name_object", 50)
    val nameJp = varchar("name_jp", 50).nullable()
    val transcriptionJp = varchar("transcription_jp_name", 50).nullable()
}

data class InventoryDTO(
    val id: Int,
    val mangaId: Int,
    val placeId: Int,
    val image: String?,
    val description: String?,
    val name: String,
    val nameJp: String?,
    val transcriptionJp: String?,
)

fun InventoryDTO.toResponse() = InventoryResponse(
    id = id,
    mangaId = mangaId,
    placeId = placeId,
    image = image,
    description = description,
    name = name,
    nameJp = nameJp,
    transcriptionJp = transcriptionJp
)