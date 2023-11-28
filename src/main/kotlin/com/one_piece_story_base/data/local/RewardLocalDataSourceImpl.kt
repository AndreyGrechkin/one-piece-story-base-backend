package com.one_piece_story_base.data.local

import com.one_piece_story_base.BaseUrl
import com.one_piece_story_base.data.model.*
import com.one_piece_story_base.domain.local.RewardLocalDataSource
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class RewardLocalDataSourceImpl : RewardLocalDataSource {
    override fun fetchReward(): List<PersonageRewardDTO> {
        return try {
            transaction {
                PersonageRewardTable
                    .selectAll()
                    .toList()
                    .map { reward ->
                        PersonageRewardDTO(
                            id = reward[PersonageRewardTable.id],
                            personageId = reward[PersonageRewardTable.personageId],
                            mangaId = reward[PersonageRewardTable.mangaId],
                            reward = reward[PersonageRewardTable.reward],
                            rewardType = reward[PersonageRewardTable.rewardType],
                            image = if (reward[PersonageRewardTable.image] != null) BaseUrl + "static/reward/${reward[PersonageRewardTable.image]}" else null,
                            placeId = reward[PersonageRewardTable.placeId]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchRewardByPlaceId(placeId: Int): List<PersonageRewardDTO> {
        return try {
            transaction {
                PersonageRewardTable.innerJoin(MangaTable)
                    .select(
                        where = PersonageRewardTable.mangaId.eq(MangaTable.id)
                                and MangaTable.placeId.eq(placeId)
                    )
                    .toList()
                    .map { reward ->
                        PersonageRewardDTO(
                            id = reward[PersonageRewardTable.id],
                            personageId = reward[PersonageRewardTable.personageId],
                            mangaId = reward[PersonageRewardTable.mangaId],
                            reward = reward[PersonageRewardTable.reward],
                            rewardType = reward[PersonageRewardTable.rewardType],
                            image = if (reward[PersonageRewardTable.image] != null) BaseUrl + "static/reward/${reward[PersonageRewardTable.image]}" else null,
                            placeId = reward[PersonageRewardTable.placeId]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchRewardById(id: Int): PersonageRewardDTO? {
        return try {
            transaction {
                val reward = PersonageRewardTable
                    .select(PersonageRewardTable.id.eq(id)).single()
                PersonageRewardDTO(
                    id = reward[PersonageRewardTable.id],
                    personageId = reward[PersonageRewardTable.personageId],
                    mangaId = reward[PersonageRewardTable.mangaId],
                    reward = reward[PersonageRewardTable.reward],
                    rewardType = reward[PersonageRewardTable.rewardType],
                    image = if (reward[PersonageRewardTable.image] != null) BaseUrl + "static/reward/${reward[PersonageRewardTable.image]}" else null,
                    placeId = reward[PersonageRewardTable.placeId]
                )
            }
        } catch (e: Exception) {
            null
        }
    }

}