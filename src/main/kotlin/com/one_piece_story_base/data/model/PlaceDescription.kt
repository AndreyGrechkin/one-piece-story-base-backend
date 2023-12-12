package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.place.PlaceDescriptionResponse
import org.jetbrains.exposed.sql.Table

object PlaceDescriptionTable : Table(name = "place_description") {
    val id = integer("id")
    val placeId = integer("place_id").references(PlaceTable.id)
    val mangaId = integer("manga_id").references(MangaTable.id)
    val description = text("description").nullable()
    val event = text("event_place").nullable()
    val image = text("image").nullable()
}

data class PlaceDescriptionDTO(
    val id: Int,
    val placeId: Int,
    val mangaId: Int,
    val description: String?,
    val event: String?,
    val image: String?,
)

fun PlaceDescriptionDTO.toResponse() = PlaceDescriptionResponse(
    id = id,
    placeId = placeId,
    mangaId = mangaId,
    description = description,
    event = event,
    image = image
)