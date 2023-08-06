package com.one_piece_story_base.domain.controller

import com.one_piece_story_base.data.model.toResponse
import com.one_piece_story_base.domain.local.InventoryLocalDataSource
import com.one_piece_story_base.domain.model.inventory.InventoryApiResponse
import com.one_piece_story_base.routing.repository.InventoryController

class InventoryControllerImpl(
    private  val dao: InventoryLocalDataSource
): InventoryController {
    override suspend fun getAllInventory(): InventoryApiResponse {
        val daoInventory = dao.fetchInventory()
        return  InventoryApiResponse(response = daoInventory.map { it.toResponse() })
    }

    override suspend fun getInventoryByPlaceId(placeId: Int): InventoryApiResponse {
        val daoInventory = dao.fetchInventoryByPlaceId(placeId).map { it.toResponse() }
        return InventoryApiResponse(response = daoInventory)
    }
}