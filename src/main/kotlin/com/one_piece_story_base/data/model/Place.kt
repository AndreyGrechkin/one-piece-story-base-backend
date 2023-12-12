package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.place.PlaceMangaResponse
import com.one_piece_story_base.domain.model.place.PlaceResponse
import org.jetbrains.exposed.sql.Table

object PlaceTable : Table(name = "place") {
    val id = integer("id")
    val namePlace = varchar("name_place", 50).nullable()
    val country = varchar("country", 50).nullable()
    val mangaId = integer("manga_id").references(MangaTable.id)
    val sea = varchar("sea", 50).nullable()
    val islandType = varchar("island_type", 50).nullable()
    val nameIsland = varchar("name_island", 50).nullable()
    val nameJp = varchar("name_jp", 50).nullable()
    val transcriptionJp = varchar("transcription_jp_name", 50).nullable()
    val timeStep = long("time_step")
    val placeDetailImage = text("place_detail_image").nullable()
}

data class PlaceDTO(
    val id: Int,
    val namePlace: String?,
    val country: String?,
    val mangaId: Int,
    val sea: String?,
    val islandType: String?,
    val nameIsland: String?,
    val nameJp: String?,
    val transcriptionJp: String?,
    val timeStep: Long,
    val placeDetailImage: String?,
)

fun PlaceDTO.toResponse() = PlaceResponse(
    id = id,
    namePlace = namePlace,
    country = country,
    mangaId = mangaId,
    sea = sea,
    islandType = islandType,
    nameIsland = nameIsland,
    nameJp = nameJp,
    transcriptionJp = transcriptionJp,
    timeStep = timeStep,
    placeDetailImage = placeDetailImage
)

fun PlaceDTO.toPlaceManga(mangaDTO: List<MangaDTO>) = PlaceMangaResponse(
    id = id,
    namePlace = namePlace,
    country = country,
    mangaId = mangaDTO.filter { it.id == mangaId }.map { it.toResponse() },
    sea = sea,
    islandType = islandType,
    nameIsland = nameIsland,
    nameJp = nameJp,
    transcriptionJp = transcriptionJp,
    timeStep = timeStep,
    placeDetailImage = placeDetailImage
)

