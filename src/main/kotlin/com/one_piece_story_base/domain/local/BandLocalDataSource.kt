package com.one_piece_story_base.domain.local

import com.one_piece_story_base.data.model.BandDTO
import com.one_piece_story_base.data.model.BandDescriptionDTO
import com.one_piece_story_base.data.model.BandPersonageDTO

interface BandLocalDataSource {
    fun fetchBand(): List<BandDTO>
    fun fetchBandById(id: Int): BandDTO?
    fun fetchBandByPlaceId(placeId: Int): List<BandDTO>
    fun fetchBandByPersonageId(personageId: Int): List<BandDTO>
    fun fetchBandPersonage(): List<BandPersonageDTO>
    fun fetchBandDescriptionByPlace(placeId: Int): List<BandDescriptionDTO>
    fun fetchBandPersonageByPlace(placeId: Int): List<BandPersonageDTO>
}