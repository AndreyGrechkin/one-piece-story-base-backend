package com.one_piece_story_base.domain.local

import com.one_piece_story_base.data.model.PlaceDTO
import com.one_piece_story_base.data.model.PlaceDescriptionDTO
import com.one_piece_story_base.data.model.PlaceItemDTO
import com.one_piece_story_base.data.model.PlaceTransitItemDTO

interface PlaceLocalDataSource {
    fun fetchPlace(): List<PlaceDTO>
    fun fetchPlaceDescription(): List<PlaceDescriptionDTO>
    fun fetchPlaceDescriptionByPlaceId(placeId: Int): List<PlaceDescriptionDTO>
    fun fetchPlaceById(id: Int): PlaceDTO?
    fun fetchPlaceItemByPlaceId(placeId: Int): List<PlaceItemDTO>
    fun fetchPlaceItem(): List<PlaceItemDTO>
    fun fetchTransitItemByPlace(placeId: Int): List<PlaceTransitItemDTO>
}