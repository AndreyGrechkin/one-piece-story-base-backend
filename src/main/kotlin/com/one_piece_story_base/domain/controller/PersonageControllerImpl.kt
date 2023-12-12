package com.one_piece_story_base.domain.controller

import com.one_piece_story_base.data.model.toResponse
import com.one_piece_story_base.domain.local.BandLocalDataSource
import com.one_piece_story_base.domain.local.PersonageLocalDataSource
import com.one_piece_story_base.domain.model.personage.*
import com.one_piece_story_base.routing.repository.PersonageController

class PersonageControllerImpl(
    private val dao: PersonageLocalDataSource,
    private val band: BandLocalDataSource,
) : PersonageController {
    override suspend fun getPersonage(): PersonageApiResponse {
        val daoPersonage = dao.fetchPersonage()
        return PersonageApiResponse(response = daoPersonage.map { it.toResponse() })
    }

    override suspend fun getPersonageList(): PersonageListApiResponse {
        val daoPersonage = dao.fetchPersonage()
        val daoDescription = dao.fetchDescription()
        val daoBand = band.fetchBand()
        val daoBandPersonage = band.fetchBandPersonage()
        val mapPersonageList = daoPersonage.map { personage ->
            val description = daoDescription.filter { it.personageId == personage.id }.map { it.toResponse() }
            val bandPersonage = daoBandPersonage.filter { it.personageId == personage.id }
                .map { bandPersonage ->
                    bandPersonage.bandId
                }
            val band = daoBand.filter { band ->
                bandPersonage.contains(band.id)
            }.map { it.toResponse() }
            PersonageListResponse(
                id = personage.id,
                mangaId = personage.mangaId,
                placeId = personage.placeId,
                name = personage.name,
                nameJp = personage.nameJp,
                transcriptionJp = personage.transcriptionJp,
                avatar = personage.avatar,
                description = description,
                band = band
            )
        }
        return PersonageListApiResponse(response = mapPersonageList)
    }

    override suspend fun getPersonageListByPlaceId(placeId: Int): PersonageListApiResponse {
        val daoPersonage = dao.fetchPersonageByPlaceId(placeId)
        val daoDescription = dao.fetchDescription()
        val daoBand = band.fetchBand()
        val daoBandPersonage = band.fetchBandPersonage()
        val mapPersonageList = daoPersonage.map { personage ->
            val description = daoDescription.filter { it.personageId == personage.id }.map { it.toResponse() }
            val bandPersonage = daoBandPersonage.filter { it.personageId == personage.id }
                .map { bandPersonage ->
                    bandPersonage.bandId
                }
            val band = daoBand.filter { band ->
                bandPersonage.contains(band.id)
            }.map { it.toResponse() }
            PersonageListResponse(
                id = personage.id,
                mangaId = personage.mangaId,
                placeId = personage.placeId,
                name = personage.name,
                nameJp = personage.nameJp,
                transcriptionJp = personage.transcriptionJp,
                avatar = personage.avatar,
                description = description,
                band = band
            )
        }
        return PersonageListApiResponse(response = mapPersonageList)
    }

    override suspend fun getPersonageByPlaceId(placeId: Int): PersonageApiResponse {
        val daoPersonage = dao.fetchPersonageListByPlaceId(placeId).map { it.toResponse() }
        return PersonageApiResponse(response = daoPersonage)
    }

    override suspend fun getPersonageDescriptionByPlaceId(placeId: Int): PersonageDescriptionApiResponse {
        val personageDescription = dao.fetchDescriptionByPlaceId(placeId).map { it.toResponse() }
        return PersonageDescriptionApiResponse(response = personageDescription)
    }

    override suspend fun getSkillByPlaceId(placeId: Int): PersonageSkillApiResponse {
        val skill = dao.fetchSkillByPlaceId(placeId).map { it.toResponse() }
        return PersonageSkillApiResponse(response = skill)
    }

    override suspend fun getWeaponByPlaceId(placeId: Int): PersonageWeaponsApiResponse {
        val weapon = dao.fetchWeaponByPlaceId(placeId).map { it.toResponse() }
        return PersonageWeaponsApiResponse(response = weapon)
    }
}