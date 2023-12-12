package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.band.BandDescriptionResponse
import org.jetbrains.exposed.sql.Table

object BandDescriptionTable : Table(name = "band_description") {
    val id = integer("id")
    val bandId = integer("band_id").references(BandTable.id)
    val mangaId = integer("manga_id").references(MangaTable.id)
    val description = text("description").nullable()
}

data class BandDescriptionDTO(
    val id: Int,
    val bandId: Int,
    val mangaId: Int,
    val description: String?,
)

fun BandDescriptionDTO.toResponse() = BandDescriptionResponse(
    id = id,
    bandId = bandId,
    mangaId = mangaId,
    description = description
)