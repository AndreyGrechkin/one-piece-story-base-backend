package com.one_piece_story_base.data.local

import com.one_piece_story_base.data.model.BondDTO
import com.one_piece_story_base.data.model.BondTable
import com.one_piece_story_base.data.model.MangaTable
import com.one_piece_story_base.domain.local.BondLocalDataSource
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class BondLocalDataSourceImpl : BondLocalDataSource {
    override fun fetchBondByPlace(placeId: Int): List<BondDTO> {
        return try {
            transaction {
                BondTable.innerJoin(MangaTable)
                    .select(
                        where = BondTable.mangaId.eq(MangaTable.id)
                                and MangaTable.placeId.eq(placeId)
                    )
                    .toList()
                    .map { bond ->
                        BondDTO(
                            id = bond[BondTable.id],
                            personageId = bond[BondTable.personageId],
                            mangaId = bond[BondTable.mangaId],
                            bondPersonageId = bond[BondTable.bondPersonageId],
                            description = bond[BondTable.description],
                            bondType = bond[BondTable.bondType]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}