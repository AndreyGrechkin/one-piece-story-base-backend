package com.one_piece_story_base.data.model

import com.one_piece_story_base.domain.model.personage.PersonageForPlaceResponse
import com.one_piece_story_base.domain.model.personage.PersonageResponse
import org.jetbrains.exposed.sql.Table

object PersonageTable: Table(name = "personage") {
    val id = integer("id")
    val mangaId = integer("manga_id").references(MangaTable.id)
    val placeId = integer("place_id").references(PlaceTable.id)
    val name = varchar("main_name", 50)
    val nameJp = varchar("name_jp", 50).nullable()
    val transcriptionJp = varchar("transcription_jp_name", 50).nullable()
    val  avatar = text("avatar").nullable()
}

data class PersonageDTO(
    val id: Int,
    val mangaId: Int,
    val placeId: Int,
    val name: String,
    val nameJp: String?,
    val transcriptionJp: String?,
    val avatar: String?
)

data class PersonageForPlaceDTO(
    val id: Int,
    val mangaId: Int,
    val placeId: Int,
    val name: String,
    val nameJp: String?,
    val transcriptionJp: String?,
    val avatar: String?,
    val image: String?,
    val fruit: String?
)

fun PersonageDTO.toResponse() = PersonageResponse(
    id = id,
    mangaId = mangaId,
    placeId = placeId,
    name = name,
    nameJp = nameJp,
    transcriptionJp = transcriptionJp,
    avatar = avatar
)

fun PersonageForPlaceDTO.toResponse() = PersonageForPlaceResponse(
    id = id,
    mangaId = mangaId,
    placeId = placeId,
    name = name,
    nameJp = nameJp,
    transcriptionJp = transcriptionJp,
    avatar = avatar,
    image = image,
    fruit = fruit
)