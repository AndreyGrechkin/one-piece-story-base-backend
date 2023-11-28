package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.ship.ShipResponse
import org.jetbrains.exposed.sql.Table

object ShipTable: Table(name = "ship") {
    val id = integer("id")
    val bandId = integer("band_id").references(BandTable.id)
    val mangaId = integer("manga_id").references(MangaTable.id)
    val nameShip = varchar("name_ship", 50).nullable()
    val description = text("description").nullable()
    val oldShip = integer("old_ship").nullable()
    val nameJp = varchar("name_jp", 50).nullable()
    val transcriptionJp = varchar("transcription_jp_name", 50).nullable()
    val image = text("image").nullable()
}

data class ShipDTO(
    val id: Int,
    val bandId: Int,
    val mangaId: Int,
    val nameShip: String?,
    val description: String?,
    val oldShip: Int?,
    val nameJp: String?,
    val transcriptionJp: String?,
    val image: String?,
)

fun  ShipDTO.toResponse() = ShipResponse(
    id = id,
    bandId = bandId,
    mangaId = mangaId,
    nameShip = nameShip,
    description = description,
    oldShip = oldShip,
    nameJp = nameJp,
    transcriptionJp = transcriptionJp,
    image = image
)