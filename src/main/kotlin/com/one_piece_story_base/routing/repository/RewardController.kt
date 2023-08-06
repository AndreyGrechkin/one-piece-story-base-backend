package com.one_piece_story_base.routing.repository

import com.one_piece_story_base.domain.model.personage.PersonageRewardApiResponse
import com.one_piece_story_base.domain.model.personage.PersonageRewardResponse

interface RewardController {
    suspend fun getAllReward(): PersonageRewardApiResponse
    suspend fun getAllRewardPlace(placeId: Int): PersonageRewardApiResponse
    suspend fun getRewardById(id: Int): PersonageRewardResponse?
}