package com.one_piece_story_base.data.local

import com.one_piece_story_base.data.model.*
import com.one_piece_story_base.domain.local.IslandLocalDataSource
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class IslandLocalDataSourceImpl : IslandLocalDataSource {
    override fun fetchIsland(): List<IslandDTO> {
        return try {
            transaction {
                IslandTable
                    .selectAll()
                    .toList()
                    .map { island ->
                        IslandDTO(
                            id = island[IslandTable.id],
                            name = island[IslandTable.name],
                            nameImage = island[IslandTable.nameImage],
                            posX = island[IslandTable.posX],
                            posY = island[IslandTable.posY],
                            placeId = island[IslandTable.placeId]
                        )
                    }
            }
        } catch (e: Throwable) {
            emptyList()
        }
    }

    override fun fetchPersonageIsland(placeId: Int): List<PersonageIslandDTO> {
        return try {
            transaction {
                PersonageIslandTable
                    .select(where = PersonageIslandTable.placeId.eq(placeId))
                    .toList()
                    .map {
                        PersonageIslandDTO(
                            id = it[PersonageIslandTable.id],
                            placeId = it[PersonageIslandTable.placeId],
                            nameAvatar = it[PersonageIslandTable.nameAvatar],
                            nameImage = it[PersonageIslandTable.nameImage],
                            posX = it[PersonageIslandTable.posX],
                            posY = it[PersonageIslandTable.posY]
                        )
                    }
            }
        } catch (e: Throwable) {
            emptyList()
        }
    }

    override fun fetchIslandTransit(placeId: Int): List<IslandTransitDTO> {
        return try {
            transaction {
                IslandTransitTable
                    .select(where = IslandTransitTable.placeId.eq(placeId))
                    .toList()
                    .map {
                        IslandTransitDTO(
                            id = it[IslandTransitTable.id],
                            avatarId = it[IslandTransitTable.avatarId],
                            placeId = it[IslandTransitTable.placeId],
                            posX = it[IslandTransitTable.posX],
                            posY = it[IslandTransitTable.posY]
                        )
                    }
            }
        } catch (e: Throwable) {
            emptyList()
        }
    }
}