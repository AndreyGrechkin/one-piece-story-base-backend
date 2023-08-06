package com.one_piece_story_base.data.local

import com.one_piece_story_base.data.model.MangaDTO
import com.one_piece_story_base.data.model.MangaTable
import com.one_piece_story_base.domain.local.MangaLocalDataSource
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class MangaLocalDataSourceImpl : MangaLocalDataSource {
    override fun fetchManga(): List<MangaDTO> {
        return try {
            transaction {
                MangaTable.selectAll().toList().map { mangaModel ->
                    MangaDTO(
                        id = mangaModel[MangaTable.id],
                        volume = mangaModel[MangaTable.volume],
                        chapter = mangaModel[MangaTable.chapter],
                        animeType = mangaModel[MangaTable.animeType],
                        animeSeries = mangaModel[MangaTable.animeSeries],
                        description = mangaModel[MangaTable.description],
                        placeId = mangaModel[MangaTable.placeId]
                    )
                }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchMangaByPlaceId(placeId: Int): List<MangaDTO> {
        return try {
            transaction {
                MangaTable.select(where = MangaTable.placeId.eq(placeId))
                    .toList()
                    .map { mangaModel ->
                        MangaDTO(
                            id = mangaModel[MangaTable.id],
                            volume = mangaModel[MangaTable.volume],
                            chapter = mangaModel[MangaTable.chapter],
                            animeType = mangaModel[MangaTable.animeType],
                            animeSeries = mangaModel[MangaTable.animeSeries],
                            description = mangaModel[MangaTable.description],
                            placeId = mangaModel[MangaTable.placeId]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchMangaById(id: Int): MangaDTO? {
        return try {
            transaction {
                val mangaModel = MangaTable
                    .select(MangaTable.id.eq(id)).single()
                MangaDTO(
                    id = mangaModel[MangaTable.id],
                    volume = mangaModel[MangaTable.volume],
                    chapter = mangaModel[MangaTable.chapter],
                    animeType = mangaModel[MangaTable.animeType],
                    animeSeries = mangaModel[MangaTable.animeSeries],
                    description = mangaModel[MangaTable.description],
                    placeId = mangaModel[MangaTable.placeId]
                )
            }
        } catch (e: Exception) {
            null
        }
    }

    override fun insert(mangaDTO: MangaDTO) {
        transaction {
            MangaTable.insert {
                it[id] = mangaDTO.id
                it[volume] = mangaDTO.volume
                it[chapter] = mangaDTO.chapter
                it[animeType] = mangaDTO.animeType
                it[animeSeries] = mangaDTO.animeSeries
                it[description] = mangaDTO.description
            }
        }
    }
}