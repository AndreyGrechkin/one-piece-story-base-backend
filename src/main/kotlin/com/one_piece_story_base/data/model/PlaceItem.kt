package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.place.PlaceItemResponse
import org.jetbrains.exposed.sql.Table

object PlaceItemTable: Table(name = "place_item") {
    val id = integer("id")
    val placeId = integer("place_id").references(PlaceTable.id)
    val nameItem = varchar("name_item", 50).nullable()
    val nameJp = varchar("name_jp", 50).nullable()
    val transcriptionJp = varchar("transcription_name", 50).nullable()
    val description = text("description").nullable()
    val image = text("image").nullable()
}

data class PlaceItemDTO(
    val id: Int,
    val placeId: Int,
    val nameItem: String?,
    val nameJp: String?,
    val transcriptionJp: String?,
    val description: String?,
    val image: String?,
)

fun PlaceItemDTO.toResponse() = PlaceItemResponse(
    id = id,
    placeId = placeId,
    nameItem = nameItem,
    nameJp = nameJp,
    transcriptionJp = transcriptionJp,
    description = description,
    image = image
)