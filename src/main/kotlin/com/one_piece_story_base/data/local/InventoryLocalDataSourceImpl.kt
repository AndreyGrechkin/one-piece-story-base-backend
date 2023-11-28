package com.one_piece_story_base.data.local

import com.one_piece_story_base.BaseUrl
import com.one_piece_story_base.data.model.InventoryDTO
import com.one_piece_story_base.data.model.InventoryTable
import com.one_piece_story_base.domain.local.InventoryLocalDataSource
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class InventoryLocalDataSourceImpl : InventoryLocalDataSource {
    override fun fetchInventory(): List<InventoryDTO> {
        return try {
            transaction {
                InventoryTable
                    .selectAll()
                    .toList()
                    .map { inventory ->
                        InventoryDTO(
                            id = inventory[InventoryTable.id],
                            mangaId = inventory[InventoryTable.mangaId],
                            placeId = inventory[InventoryTable.placeId],
                            image = if (inventory[InventoryTable.image] != null) BaseUrl + "static/inventory/${inventory[InventoryTable.image]}" else null,
                            description = inventory[InventoryTable.description],
                            name = inventory[InventoryTable.name],
                            nameJp = inventory[InventoryTable.nameJp],
                            transcriptionJp = inventory[InventoryTable.transcriptionJp]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchInventoryByPlaceId(placeId: Int): List<InventoryDTO> {
        return try {
            transaction {
                InventoryTable
                    .select(where = InventoryTable.placeId.eq(placeId))
                    .toList()
                    .map { inventory ->
                        InventoryDTO(
                            id = inventory[InventoryTable.id],
                            mangaId = inventory[InventoryTable.mangaId],
                            placeId = inventory[InventoryTable.placeId],
                            image = if (inventory[InventoryTable.image] != null) BaseUrl + "static/inventory/${inventory[InventoryTable.image]}" else null,
                            description = inventory[InventoryTable.description],
                            name = inventory[InventoryTable.name],
                            nameJp = inventory[InventoryTable.nameJp],
                            transcriptionJp = inventory[InventoryTable.transcriptionJp]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun fetchInventoryById(id: Int): InventoryDTO? {
        return try {
            transaction {
                val inventory = InventoryTable
                    .select(InventoryTable.id.eq(id)).single()
                InventoryDTO(
                    id = inventory[InventoryTable.id],
                    mangaId = inventory[InventoryTable.mangaId],
                    placeId = inventory[InventoryTable.placeId],
                    image = if (inventory[InventoryTable.image] != null) BaseUrl + "static/inventory/${inventory[InventoryTable.image]}" else null,
                    description = inventory[InventoryTable.description],
                    name = inventory[InventoryTable.name],
                    nameJp = inventory[InventoryTable.nameJp],
                    transcriptionJp = inventory[InventoryTable.transcriptionJp]
                )
            }
        } catch (e: Exception) {
            null
        }
    }
}