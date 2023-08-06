package com.one_piece_story_base.domain.controller

import com.one_piece_story_base.data.model.toResponse
import com.one_piece_story_base.domain.local.RewardLocalDataSource
import com.one_piece_story_base.domain.model.personage.PersonageRewardApiResponse
import com.one_piece_story_base.domain.model.personage.PersonageRewardResponse
import com.one_piece_story_base.routing.repository.RewardController

class RewardControllerImpl(
    private val dao: RewardLocalDataSource
) : RewardController {
    override suspend fun getAllReward(): PersonageRewardApiResponse {
        return PersonageRewardApiResponse(dao.fetchReward().map { it.toResponse() })
    }

    override suspend fun getAllRewardPlace(placeId: Int): PersonageRewardApiResponse {
        return PersonageRewardApiResponse(dao.fetchRewardByPlaceId(placeId).map { it.toResponse() })
    }

    override suspend fun getRewardById(id: Int): PersonageRewardResponse? {
        return dao.fetchRewardById(id)?.toResponse()
    }
}