package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.island.IslandTransitResponseBody
import org.jetbrains.exposed.sql.Table

object IslandTransitTable : Table(name = "personage_island_transit") {
    val id = integer("id")
    val avatarId = integer("avatar_id").references(PersonageIslandTable.id)
    val placeId = integer("place_id").references(PlaceTable.id)
    val posX = double("x_position")
    val posY = double("y_position")
}

data class IslandTransitDTO(
    val id: Int,
    val avatarId: Int,
    val placeId: Int,
    val posX: Double,
    val posY: Double,
)

fun IslandTransitDTO.toResponse() = IslandTransitResponseBody(
    id = id,
    avatarId = avatarId,
    placeId = placeId,
    posX = posX,
    posY = posY
)