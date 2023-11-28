package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.island.PersonageIslandResponseBody
import org.jetbrains.exposed.sql.Table

object PersonageIslandTable : Table(name = "personage_island") {
    val id = integer("id")
    val placeId = integer("place_id").references(PlaceTable.id)
    val nameAvatar = varchar("name_avatar", 50)
    val nameImage = varchar("name_image", 50)
    val posX = double("x_position")
    val posY = double("y_position")
}

data class PersonageIslandDTO(
    val id: Int,
    val placeId: Int,
    val nameAvatar: String,
    val nameImage: String,
    val posX: Double,
    val posY: Double,
)

fun PersonageIslandDTO.toResponse() = PersonageIslandResponseBody(
    id = id,
    placeId = placeId,
    nameAvatar = nameAvatar,
    nameImage = nameImage,
    posX = posX,
    posY = posY
)