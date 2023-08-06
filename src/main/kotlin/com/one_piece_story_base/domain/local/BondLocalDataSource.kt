package com.one_piece_story_base.domain.local

import com.one_piece_story_base.data.model.BondDTO

interface BondLocalDataSource {
    fun fetchBondByPlace(placeId: Int): List<BondDTO>
}