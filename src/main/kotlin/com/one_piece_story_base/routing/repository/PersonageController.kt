package com.one_piece_story_base.routing.repository

import com.one_piece_story_base.domain.model.personage.*


interface PersonageController {
    suspend fun getPersonage(): PersonageApiResponse
    suspend fun getPersonageList(): PersonageListApiResponse
    suspend fun getPersonageListByPlaceId(placeId: Int): PersonageListApiResponse
    suspend fun getPersonageByPlaceId(placeId: Int): PersonageApiResponse
    suspend fun getPersonageDescriptionByPlaceId(placeId: Int): PersonageDescriptionApiResponse
    suspend fun getSkillByPlaceId(placeId: Int): PersonageSkillApiResponse
    suspend fun getWeaponByPlaceId(placeId: Int): PersonageWeaponsApiResponse
}