package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.manga.MangaResponse
import org.jetbrains.exposed.sql.Table

object MangaTable : Table(name = "manga") {
    val id = integer("id")
    val volume = varchar("volume", length = 40).nullable()
    val chapter = varchar("chapter", length = 40).nullable()
    val animeType = varchar("anime_type", length = 40).nullable()
    val animeSeries = varchar("anime_series", length = 60).nullable()
    val description = text("description").nullable()
    val placeId = integer("place_id")
}

data class MangaDTO(
    val id: Int,
    val volume: String?,
    val chapter: String?,
    val animeType: String?,
    val animeSeries: String?,
    val description: String?,
    val placeId: Int,
)

fun MangaDTO.toResponse() = MangaResponse(
    id = id,
    volume = volume,
    chapter = chapter,
    animeType = animeType,
    animeSeries = animeSeries,
    description = description,
    placeId = placeId
)
