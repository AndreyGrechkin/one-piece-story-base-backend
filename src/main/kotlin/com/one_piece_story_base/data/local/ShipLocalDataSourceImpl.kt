package com.one_piece_story_base.data.local

import com.one_piece_story_base.BaseUrl
import com.one_piece_story_base.data.model.MangaTable
import com.one_piece_story_base.data.model.ShipDTO
import com.one_piece_story_base.data.model.ShipTable
import com.one_piece_story_base.domain.local.ShipLocalDataSource
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class ShipLocalDataSourceImpl: ShipLocalDataSource {
    override fun fetchShipByPlace(placeId: Int): List<ShipDTO> {
        return try {
            transaction {
                ShipTable.innerJoin(MangaTable)
                    .select(where = ShipTable.mangaId.eq(MangaTable.id)
                    and MangaTable.placeId.eq(placeId))
                    .toList()
                    .map {ship ->
                        ShipDTO(
                            id = ship[ShipTable.id],
                            bandId = ship[ShipTable.bandId],
                            mangaId = ship[ShipTable.mangaId],
                            nameShip = ship[ShipTable.nameShip],
                            description = ship[ShipTable.description],
                            oldShip = ship[ShipTable.oldShip],
                            nameJp = ship[ShipTable.nameJp],
                            transcriptionJp = ship[ShipTable.transcriptionJp],
                            image =  if (ship[ShipTable.image] != null) BaseUrl + "static/ship/${ship[ShipTable.image]}" else null
                        )
                    }
            }
        }catch (e: Exception){
            emptyList()
        }
    }
}