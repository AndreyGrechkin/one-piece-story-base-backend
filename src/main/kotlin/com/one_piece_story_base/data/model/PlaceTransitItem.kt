package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.place.PlaceTransitItemResponse
import org.jetbrains.exposed.sql.Table

object PlaceTransitItemTable : Table(name = "place_transit_item") {
    val id = integer("id")
    val mangaId = integer("manga_id").references(MangaTable.id)
    val placeId = integer("place_id").references(PlaceTable.id)
    val personageId = integer("personage_id").references(PersonageTable.id)
    val outItemId = integer("out_item_id").references(PlaceItemTable.id)
    val inItemId = integer("in_item_id").references(PlaceItemTable.id)
}

data class PlaceTransitItemDTO(
    val id: Int,
    val mangaId: Int,
    val placeId: Int,
    val personageId: Int,
    val outItemId: Int,
    val inItemId: Int,
)

fun PlaceTransitItemDTO.toResponse() = PlaceTransitItemResponse(
    id = id,
    mangaId = mangaId,
    placeId = placeId,
    personageId = personageId,
    outItemId = outItemId,
    inItemId = inItemId
)