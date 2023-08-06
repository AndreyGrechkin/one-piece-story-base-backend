package com.one_piece_story_base.routing.repository

import com.one_piece_story_base.domain.model.place.*

interface PlaceController {
    suspend fun getAllPlace(): PlaceApiResponse
    suspend fun getPlaceById(id: Int): PlaceResponse?
    suspend fun getAllMangaPlace(): PlaceMangaApiResponse
    suspend fun getMapPlace(): MapPlaceListApiResponse
    suspend fun getMapPlaceById(id: Int): MapResponse?
    suspend fun getPlaceDescriptionById(id: Int): PlaceDescriptionApiResponse
    suspend fun getPlaceItemById(id: Int): PlaceItemApiResponse
    suspend fun getTransitItemById(id: Int): PlaceTransitItemApiResponse
}