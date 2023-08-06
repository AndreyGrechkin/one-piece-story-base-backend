package com.one_piece_story_base.data.local

import com.one_piece_story_base.BaseUrl
import com.one_piece_story_base.data.model.FruitDTO
import com.one_piece_story_base.data.model.FruitTable
import com.one_piece_story_base.data.model.MangaTable
import com.one_piece_story_base.domain.local.FruitLocalDataSource
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class FruitLocalDataSourceImpl : FruitLocalDataSource {
    override fun fetchFruitByPlace(placeId: Int): List<FruitDTO> {
        return try {
            transaction {
                FruitTable.innerJoin(MangaTable)
                    .select(
                        where = FruitTable.mangaId.eq(MangaTable.id)
                                and MangaTable.placeId.eq(placeId)
                    )
                    .toList()
                    .map { fruit ->
                        FruitDTO(
                            id = fruit[FruitTable.id],
                            mangaId = fruit[FruitTable.mangaId],
                            nameFruit = fruit[FruitTable.nameFruit],
                            fruitType = fruit[FruitTable.fruitType],
                            image = if (fruit[FruitTable.image] != null) BaseUrl + "static/fruit/${fruit[FruitTable.image]}" else null,
                            description = fruit[FruitTable.description],
                            nameJp = fruit[FruitTable.nameJp],
                            transcriptionJp = fruit[FruitTable.transcriptionJp]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}