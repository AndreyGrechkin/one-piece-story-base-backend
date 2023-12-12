package com.one_piece_story_base.domain.controller

import com.one_piece_story_base.data.model.toPlaceManga
import com.one_piece_story_base.data.model.toResponse
import com.one_piece_story_base.domain.local.*
import com.one_piece_story_base.domain.model.place.*
import com.one_piece_story_base.routing.repository.PlaceController

class PlaceControllerImpl(
    private val dao: PlaceLocalDataSource,
    private val mangaDao: MangaLocalDataSource,
    private val personageDao: PersonageLocalDataSource,
    private val inventoryDao: InventoryLocalDataSource,
    private val band: BandLocalDataSource,
    private val bond: BondLocalDataSource,
    private val ship: ShipLocalDataSource,
    private val fruit: FruitLocalDataSource,
    private val reward: RewardLocalDataSource,
) : PlaceController {
    override suspend fun getAllPlace(): PlaceApiResponse {
        val daoPlace = dao.fetchPlace()
        val respond = daoPlace.map { it.toResponse() }
        return PlaceApiResponse(response = respond)
    }

    override suspend fun getPlaceById(id: Int): PlaceResponse? {
        return dao.fetchPlaceById(id)?.toResponse()
    }

    override suspend fun getAllMangaPlace(): PlaceMangaApiResponse {
        val daoPlace = dao.fetchPlace()
        val daoManga = mangaDao.fetchManga()

        val placeManga = daoPlace.map { it.toPlaceManga(daoManga) }.sortedBy { it.id }

        return PlaceMangaApiResponse(response = placeManga)

    }

    override suspend fun getMapPlace(): MapPlaceListApiResponse {
        val daoPlace = dao.fetchPlace()
        val daoManga = mangaDao.fetchManga()
        val daoPersonage = personageDao.fetchPersonageForPlace()
        val daoDescription = dao.fetchPlaceDescription()
        val daoInventory = inventoryDao.fetchInventory()
        val daoItem = dao.fetchPlaceItem()

        val mapPlaceList = daoPlace.map { place ->
            val description = daoDescription.filter { it.placeId == place.id }.map { it.toResponse() }
            val item = daoItem.filter { it.placeId == place.id }.map { it.toResponse() }
            val personage = daoPersonage.filter { it.placeId == place.id }.map { it.toResponse() }
            val inventory = daoInventory.filter { it.placeId == place.id }.map { it.toResponse() }
            val manga = daoManga.filter { it.placeId == place.id }.map { it.toResponse() }
            MapPlaceListResponse(
                id = place.id,
                namePlace = place.namePlace,
                country = place.country,
                manga = manga,
                sea = place.sea,
                islandType = place.islandType,
                nameIsland = place.nameIsland,
                nameJp = place.nameJp,
                transcriptionJp = place.transcriptionJp,
                timeStep = place.timeStep,
                description = description,
                personages = personage,
                inventory = inventory,
                itemMap = item,
                placeDetailImage = place.placeDetailImage
            )
        }
        return MapPlaceListApiResponse(response = mapPlaceList)
    }

    override suspend fun getMapPlaceById(id: Int): MapResponse? {
        val daoPlace = dao.fetchPlaceById(id)
        val daoManga = mangaDao.fetchMangaByPlaceId(id).map { it.toResponse() }
        val daoPersonage = personageDao.fetchPersonageListByPlaceId(id).map { it.toResponse() }
        val daoDescription = dao.fetchPlaceDescriptionByPlaceId(id).map { it.toResponse() }
        val daoInventory = inventoryDao.fetchInventoryByPlaceId(id).map { it.toResponse() }
        val daoItem = dao.fetchPlaceItemByPlaceId(id).map { it.toResponse() }
        val daoBand = band.fetchBandByPlaceId(id).map { it.toResponse() }
        val daoBandDescription = band.fetchBandDescriptionByPlace(id).map { it.toResponse() }
        val daoBandPersonage = band.fetchBandPersonageByPlace(id).map { it.toResponse() }
        val daoBond = bond.fetchBondByPlace(id).map { it.toResponse() }
        val daoFruit = fruit.fetchFruitByPlace(id).map { it.toResponse() }
        val daoPersonageDescription = personageDao.fetchDescriptionByPlaceId(id).map { it.toResponse() }
        val daoPersonageReward = reward.fetchRewardByPlaceId(id).map { it.toResponse() }
        val daoPersonageSkill = personageDao.fetchSkillByPlaceId(id).map { it.toResponse() }
        val daoPersonageWeapon = personageDao.fetchWeaponByPlaceId(id).map { it.toResponse() }
        val daoPlaceTransit = dao.fetchTransitItemByPlace(id).map { it.toResponse() }
        val daoShip = ship.fetchShipByPlace(id).map { it.toResponse() }
        return if (daoPlace != null)
            MapResponse(
                id = daoPlace.id,
                namePlace = daoPlace.namePlace,
                country = daoPlace.country,
                mangaId = daoPlace.mangaId,
                manga = daoManga,
                sea = daoPlace.sea,
                islandType = daoPlace.islandType,
                nameIsland = daoPlace.nameIsland,
                nameJp = daoPlace.nameJp,
                transcriptionJp = daoPlace.transcriptionJp,
                timeStep = daoPlace.timeStep,
                placeDetailImage = daoPlace.placeDetailImage,
                band = daoBand,
                bandDescription = daoBandDescription,
                bandPersonage = daoBandPersonage,
                bond = daoBond,
                fruit = daoFruit,
                inventory = daoInventory,
                personages = daoPersonage,
                personageDescription = daoPersonageDescription,
                personageReward = daoPersonageReward,
                personageSkill = daoPersonageSkill,
                personageWeapon = daoPersonageWeapon,
                placeDescription = daoDescription,
                placeItem = daoItem,
                placeTransit = daoPlaceTransit,
                ship = daoShip
            ) else
            null
    }

    override suspend fun getPlaceDescriptionById(id: Int): PlaceDescriptionApiResponse {
        val description = dao.fetchPlaceDescriptionByPlaceId(id).map { it.toResponse() }
        return PlaceDescriptionApiResponse(response = description)
    }

    override suspend fun getPlaceItemById(id: Int): PlaceItemApiResponse {
        val item = dao.fetchPlaceItemByPlaceId(id).map { it.toResponse() }
        return PlaceItemApiResponse(response = item)
    }

    override suspend fun getTransitItemById(id: Int): PlaceTransitItemApiResponse {
        val transit = dao.fetchTransitItemByPlace(id).map { it.toResponse() }
        return PlaceTransitItemApiResponse(response = transit)
    }
}