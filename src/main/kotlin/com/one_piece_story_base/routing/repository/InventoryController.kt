package com.one_piece_story_base.routing.repository

import com.one_piece_story_base.domain.model.inventory.InventoryApiResponse

interface InventoryController {
    suspend fun getAllInventory(): InventoryApiResponse
    suspend fun getInventoryByPlaceId(placeId: Int): InventoryApiResponse
}