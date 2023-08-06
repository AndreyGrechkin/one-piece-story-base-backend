package com.one_piece_story_base.domain.model.place

import com.one_piece_story_base.domain.model.band.BandDescriptionResponse
import com.one_piece_story_base.domain.model.band.BandPersonageResponse
import com.one_piece_story_base.domain.model.band.BandResponse
import com.one_piece_story_base.domain.model.bond.BondResponse
import com.one_piece_story_base.domain.model.fruit.FruitResponse
import com.one_piece_story_base.domain.model.inventory.InventoryResponse
import com.one_piece_story_base.domain.model.manga.MangaResponse
import com.one_piece_story_base.domain.model.personage.*
import com.one_piece_story_base.domain.model.ship.ShipResponse
import kotlinx.serialization.Serializable

@Serializable
data class MapPlaceListApiResponse(
    val response: List<MapPlaceListResponse>
)

@Serializable
data class MapApiResponse(
    val response: MapResponse?
)

@Serializable
data class MapPlaceListResponse(
    val id: Int,
    val namePlace: String?,
    val country: String?,
    val manga: List<MangaResponse>,
    val sea: String?,
    val islandType: String?,
    val nameIsland: String?,
    val nameJp: String?,
    val transcriptionJp: String?,
    val timeStep: Long,
    val description: List<PlaceDescriptionResponse>,
    val personages: List<PersonageForPlaceResponse>,
    val inventory: List<InventoryResponse>,
    val itemMap: List<PlaceItemResponse>,
)

@Serializable
data class MapResponse(
    val id: Int,
    val namePlace: String?,
    val country: String?,
    val mangaId: Int,
    val manga: List<MangaResponse>,
    val sea: String?,
    val islandType: String?,
    val nameIsland: String?,
    val nameJp: String?,
    val transcriptionJp: String?,
    val timeStep: Long,
    val band: List<BandResponse>,
    val bandDescription: List<BandDescriptionResponse>,
    val bandPersonage: List<BandPersonageResponse>,
    val bond: List<BondResponse>,
    val fruit: List<FruitResponse>,
    val inventory: List<InventoryResponse>,
    val personages: List<PersonageResponse>,
    val personageDescription: List<PersonageDescriptionResponse>,
    val personageReward: List<PersonageRewardResponse>,
    val personageSkill: List<PersonageSkillResponse>,
    val personageWeapon: List<PersonageWeaponsResponse>,
    val placeDescription: List<PlaceDescriptionResponse>,
    val placeItem: List<PlaceItemResponse>,
    val placeTransit: List<PlaceTransitItemResponse>,
    val ship: List<ShipResponse>
)