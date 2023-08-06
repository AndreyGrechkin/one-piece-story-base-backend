package com.one_piece_story_base.domain.local

import com.one_piece_story_base.data.model.PersonageRewardDTO

interface RewardLocalDataSource {
    fun fetchReward(): List<PersonageRewardDTO>
    fun fetchRewardByPlaceId(placeId: Int): List<PersonageRewardDTO>
    fun fetchRewardById(id: Int): PersonageRewardDTO?
}