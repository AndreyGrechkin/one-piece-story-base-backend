package com.one_piece_story_base.domain.model.place

import com.one_piece_story_base.domain.model.manga.MangaResponse
import kotlinx.serialization.Serializable

@Serializable
data class PlaceApiResponse(
    val response: List<PlaceResponse>,
)

@Serializable
data class PlaceResponse(
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


@Serializable
data class PlaceMangaApiResponse(
    val response: List<PlaceMangaResponse>,
)

@Serializable
data class PlaceMangaResponse(
    val id: Int,
    val namePlace: String?,
    val country: String?,
    val mangaId: List<MangaResponse>,
    val sea: String?,
    val islandType: String?,
    val nameIsland: String?,
    val nameJp: String?,
    val transcriptionJp: String?,
    val timeStep: Long,
    val placeDetailImage: String?,
)

@Serializable
data class PlaceDescriptionApiResponse(
    val response: List<PlaceDescriptionResponse>,
)

@Serializable
data class PlaceDescriptionResponse(
    val id: Int,
    val placeId: Int,
    val mangaId: Int,
    val description: String?,
    val event: String?,
    val image: String?,
)