package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.band.BandResponse
import org.jetbrains.exposed.sql.Table

object BandTable: Table(name = "band") {
    val id = integer("id")
    val mangaId = integer("manga_id").references(MangaTable.id)
    val nameBand = varchar("name_band", 50)
    val image = text("image").nullable()
    val bandType = varchar("type_band", 50).nullable()
    val nameJp = varchar("name_band_jp", 50).nullable()
    val transcriptionJp = varchar("transcription_jp_name", 50).nullable()
}

data class BandDTO(
    val id: Int,
    val mangaId: Int,
    val nameBand: String,
    val image: String?,
    val bandType: String?,
    val nameJp: String?,
    val transcriptionJp: String?,
)

fun BandDTO.toResponse() = BandResponse(
    id = id,
    mangaId = mangaId,
    nameBand = nameBand,
    image = image,
    bandType = bandType,
    nameJp = nameJp,
    transcriptionJp = transcriptionJp
)