package com.one_piece_story_base.domain.local

import com.one_piece_story_base.data.model.*

interface PersonageLocalDataSource {
    fun fetchPersonage(): List<PersonageDTO>
    fun fetchPersonageForPlace(): List<PersonageForPlaceDTO>
    fun fetchPersonageById(id: Int): PersonageDTO?
    fun fetchPersonageByPlaceId(placeId: Int): List<PersonageForPlaceDTO>
    fun fetchPersonageListByPlaceId(placeId: Int): List<PersonageDTO>
    fun fetchDescriptionByPersonageId(personageId: Int): List<PersonageDescriptionDTO>
    fun fetchDescriptionByPlaceId(placeId: Int): List<PersonageDescriptionDTO>
    fun fetchDescription(): List<PersonageDescriptionDTO>
    fun fetchSkillByPlaceId(placeId: Int): List<PersonageSkillDTO>
    fun fetchWeaponByPlaceId(placeId: Int): List<PersonageWeaponsDTO>
}