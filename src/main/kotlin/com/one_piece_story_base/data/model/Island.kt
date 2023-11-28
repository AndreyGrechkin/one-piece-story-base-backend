package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.island.IslandResponse
import org.jetbrains.exposed.sql.Table

object IslandTable: Table(name= "island") {
    val id = integer("id")
    val name = varchar("name_island", 50).nullable()
    val nameImage = varchar("name_image", 50)
    val posX = double("x_position")
    val posY = double("y_position")
    val placeId = integer("place_id").references(PlaceTable.id).nullable()
}

data class IslandDTO(
    val id: Int,
    val name: String?,
    val nameImage: String,
    val posX: Double,
    val posY: Double,
    val placeId: Int?
)

fun IslandDTO.toResponse() = IslandResponse(
    id = id,
    name = name,
    nameImage = nameImage,
    posX = posX,
    posY = posY,
    placeId = placeId
)