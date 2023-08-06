package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.band.BandPersonageResponse
import org.jetbrains.exposed.sql.Table

object BandPersonageTable: Table(name = "band_personage") {
    val id = integer("id")
    val personageId = integer("personage_id").references(PersonageTable.id)
    val bandId = integer("band_id").references(BandTable.id)
    val mangaId = integer("manga_id").references(MangaTable.id)
    val career = varchar("career", 50).nullable()
    val oldPersonage = bool("old_personage")
}

data class BandPersonageDTO(
    val id: Int,
    val personageId: Int,
    val bandId: Int,
    val mangaId: Int,
    val career: String?,
    val oldPersonage: Boolean
)

fun BandPersonageDTO.toResponse() = BandPersonageResponse(
    id = id,
    personageId = personageId,
    bandId = bandId,
    mangaId = mangaId,
    career = career,
    oldPersonage = oldPersonage
)