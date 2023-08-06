package com.one_piece_story_base.data.local

import com.one_piece_story_base.BaseUrl
import com.one_piece_story_base.data.model.*
import com.one_piece_story_base.domain.local.BandLocalDataSource
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class BandLocalDataSourceImpl : BandLocalDataSource {
    override fun fetchBand(): List<BandDTO> {
        return try {
            transaction {
                BandTable
                    .selectAll()
                    .toList()
                    .map { band ->
                        BandDTO(
                            id = band[BandTable.id],
                            mangaId = band[BandTable.mangaId],
                            nameBand = band[BandTable.nameBand],
                            image = if (band[BandTable.image] != null) BaseUrl + "static/band/${band[BandTable.image]}" else null,
                            bandType = band[BandTable.bandType],
                            nameJp = band[BandTable.nameJp],
                            transcriptionJp = band[BandTable.transcriptionJp]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchBandById(id: Int): BandDTO? {
        return try {
            transaction {
                val band = BandTable
                    .select(where = BandTable.id.eq(id)).single()
                BandDTO(
                    id = band[BandTable.id],
                    mangaId = band[BandTable.mangaId],
                    nameBand = band[BandTable.nameBand],
                    image = if (band[BandTable.image] != null) BaseUrl + "static/band/${band[BandTable.image]}" else null,
                    bandType = band[BandTable.bandType],
                    nameJp = band[BandTable.nameJp],
                    transcriptionJp = band[BandTable.transcriptionJp]
                )
            }
        } catch (e: Exception) {
            null
        }
    }

    override fun fetchBandByPlaceId(placeId: Int): List<BandDTO> {
        return try {
            transaction {
                BandTable.innerJoin(MangaTable)
                    .select(
                        where =
                        BandTable.mangaId.eq(MangaTable.id)
                                and MangaTable.placeId.eq(placeId)
                    )
                    .toList()
                    .map { band ->
                        BandDTO(
                            id = band[BandTable.id],
                            mangaId = band[BandTable.mangaId],
                            nameBand = band[BandTable.nameBand],
                            image = if (band[BandTable.image] != null) BaseUrl + "static/band/${band[BandTable.image]}" else null,
                            bandType = band[BandTable.bandType],
                            nameJp = band[BandTable.nameJp],
                            transcriptionJp = band[BandTable.transcriptionJp]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchBandByPersonageId(personageId: Int): List<BandDTO> {
        return try {
            transaction {
                BandTable.innerJoin(BandPersonageTable)
                    .select(
                        where =
                        BandTable.id.eq(BandPersonageTable.id)
                                and BandPersonageTable.personageId.eq(personageId)
                    )
                    .toList()
                    .map { band ->
                        BandDTO(
                            id = band[BandTable.id],
                            mangaId = band[BandTable.mangaId],
                            nameBand = band[BandTable.nameBand],
                            image = if (band[BandTable.image] != null) BaseUrl + "static/band/${band[BandTable.image]}" else null,
                            bandType = band[BandTable.bandType],
                            nameJp = band[BandTable.nameJp],
                            transcriptionJp = band[BandTable.transcriptionJp]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchBandPersonage(): List<BandPersonageDTO> {
        return try {
            transaction {
                BandPersonageTable
                    .selectAll()
                    .toList()
                    .map { band ->
                        BandPersonageDTO(
                            id = band[BandPersonageTable.id],
                            personageId = band[BandPersonageTable.personageId],
                            bandId = band[BandPersonageTable.bandId],
                            mangaId = band[BandPersonageTable.mangaId],
                            career = band[BandPersonageTable.career],
                            oldPersonage = band[BandPersonageTable.oldPersonage]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchBandDescriptionByPlace(placeId: Int): List<BandDescriptionDTO> {
        return try {
            transaction {
                BandDescriptionTable.innerJoin(MangaTable)
                    .select(
                        where = BandDescriptionTable.mangaId.eq(MangaTable.id)
                                and MangaTable.placeId.eq(placeId)
                    )
                    .toList()
                    .map { desc ->
                        BandDescriptionDTO(
                            id = desc[BandDescriptionTable.id],
                            bandId = desc[BandDescriptionTable.bandId],
                            mangaId = desc[BandDescriptionTable.mangaId],
                            description = desc[BandDescriptionTable.description]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchBandPersonageByPlace(placeId: Int): List<BandPersonageDTO> {
        return try {
            transaction {
                BandPersonageTable.innerJoin(MangaTable)
                    .select(
                        where = BandPersonageTable.mangaId.eq(MangaTable.id)
                                and MangaTable.placeId.eq(placeId)
                    )
                    .toList()
                    .map { band ->
                        BandPersonageDTO(
                            id = band[BandPersonageTable.id],
                            bandId = band[BandPersonageTable.bandId],
                            mangaId = band[BandPersonageTable.mangaId],
                            personageId = band[BandPersonageTable.personageId],
                            career = band[BandPersonageTable.career],
                            oldPersonage = band[BandPersonageTable.oldPersonage]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}