package com.one_piece_story_base.data.local

import com.one_piece_story_base.BaseUrl
import com.one_piece_story_base.data.model.*
import com.one_piece_story_base.domain.local.PlaceLocalDataSource
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class PlaceLocalDataSourceImpl : PlaceLocalDataSource {
    override fun fetchPlace(): List<PlaceDTO> {
        return try {
            transaction {
                PlaceTable
                    .selectAll()
                    .toList()
                    .map { place ->
                        PlaceDTO(
                            id = place[PlaceTable.id],
                            namePlace = place[PlaceTable.namePlace],
                            country = place[PlaceTable.country],
                            mangaId = place[PlaceTable.mangaId],
                            sea = place[PlaceTable.sea],
                            islandType = place[PlaceTable.islandType],
                            nameIsland = place[PlaceTable.nameIsland],
                            nameJp = place[PlaceTable.nameJp],
                            transcriptionJp = place[PlaceTable.transcriptionJp],
                            timeStep = place[PlaceTable.timeStep]
                        )
                    }
            }
        } catch (e: Throwable) {
            emptyList()
        }
    }

    override fun fetchPlaceDescription(): List<PlaceDescriptionDTO> {
        return try {
            transaction {
                PlaceDescriptionTable
                    .selectAll()
                    .toList()
                    .map {
                        PlaceDescriptionDTO(
                            id = it[PlaceDescriptionTable.id],
                            placeId = it[PlaceDescriptionTable.placeId],
                            mangaId = it[PlaceDescriptionTable.mangaId],
                            description = it[PlaceDescriptionTable.description],
                            event = it[PlaceDescriptionTable.event],
                            image = if (it[PlaceDescriptionTable.image] != null) BaseUrl + "static/place/${it[PlaceDescriptionTable.image]}" else null
                        )
                    }
            }
        } catch (e: Throwable) {
            emptyList()
        }
    }

    override fun fetchPlaceDescriptionByPlaceId(placeId: Int): List<PlaceDescriptionDTO> {
        return try {
            transaction {
                PlaceDescriptionTable
                    .select(where = PlaceDescriptionTable.placeId.eq(placeId))
                    .toList()
                    .map {
                        PlaceDescriptionDTO(
                            id = it[PlaceDescriptionTable.id],
                            placeId = it[PlaceDescriptionTable.placeId],
                            mangaId = it[PlaceDescriptionTable.mangaId],
                            description = it[PlaceDescriptionTable.description],
                            event = it[PlaceDescriptionTable.event],
                            image = if (it[PlaceDescriptionTable.image] != null) BaseUrl + "static/place/${it[PlaceDescriptionTable.image]}" else null
                        )
                    }
            }
        } catch (e: Throwable) {
            emptyList()
        }
    }

    override fun fetchPlaceById(id: Int): PlaceDTO? {
        return try {
            transaction {
                val place = PlaceTable
                    .select(where = PlaceTable.id.eq(id)).single()
                PlaceDTO(
                    id = place[PlaceTable.id],
                    namePlace = place[PlaceTable.namePlace],
                    country = place[PlaceTable.country],
                    mangaId = place[PlaceTable.mangaId],
                    sea = place[PlaceTable.sea],
                    islandType = place[PlaceTable.islandType],
                    nameIsland = place[PlaceTable.nameIsland],
                    nameJp = place[PlaceTable.nameJp],
                    transcriptionJp = place[PlaceTable.transcriptionJp],
                    timeStep = place[PlaceTable.timeStep]
                )
            }
        } catch (e: Throwable) {
            null
        }
    }

    override fun fetchPlaceItemByPlaceId(placeId: Int): List<PlaceItemDTO> {
        return try {
            transaction {
                PlaceItemTable
                    .select(where = PlaceItemTable.placeId.eq(placeId))
                    .toList()
                    .map {
                        PlaceItemDTO(
                            id = it[PlaceItemTable.id],
                            placeId = it[PlaceItemTable.placeId],
                            nameItem = it[PlaceItemTable.nameItem],
                            nameJp = it[PlaceItemTable.nameJp],
                            transcriptionJp = it[PlaceItemTable.transcriptionJp],
                            description = it[PlaceItemTable.description],
                            image = if (it[PlaceItemTable.image] != null) BaseUrl + "static/place/item/${it[PlaceItemTable.image]}" else null
                        )
                    }
            }
        } catch (e: Throwable) {
            emptyList()
        }
    }

    override fun fetchPlaceItem(): List<PlaceItemDTO> {
        return try {
            transaction {
                PlaceItemTable
                    .selectAll()
                    .toList()
                    .map {
                        PlaceItemDTO(
                            id = it[PlaceItemTable.id],
                            placeId = it[PlaceItemTable.placeId],
                            nameItem = it[PlaceItemTable.nameItem],
                            nameJp = it[PlaceItemTable.nameJp],
                            transcriptionJp = it[PlaceItemTable.transcriptionJp],
                            description = it[PlaceItemTable.description],
                            image = if (it[PlaceItemTable.image] != null) BaseUrl + "static/place/item/${it[PlaceItemTable.image]}" else null
                        )
                    }
            }
        } catch (e: Throwable) {
            emptyList()
        }
    }

    override fun fetchTransitItemByPlace(placeId: Int): List<PlaceTransitItemDTO> {
        return try {
            transaction {
                PlaceTransitItemTable
                    .select(where = PlaceTransitItemTable.placeId.eq(placeId))
                    .toList()
                    .map { transit ->
                        PlaceTransitItemDTO(
                            id = transit[PlaceTransitItemTable.id],
                            mangaId = transit[PlaceTransitItemTable.mangaId],
                            placeId = transit[PlaceTransitItemTable.placeId],
                            personageId = transit[PlaceTransitItemTable.personageId],
                            outItemId = transit[PlaceTransitItemTable.outItemId],
                            inItemId = transit[PlaceTransitItemTable.inItemId]
                        )
                    }
            }
        } catch (e: Throwable) {
            emptyList()
        }
    }
}