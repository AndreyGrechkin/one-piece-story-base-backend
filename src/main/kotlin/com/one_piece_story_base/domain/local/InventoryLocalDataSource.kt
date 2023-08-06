package com.one_piece_story_base.domain.local

import com.one_piece_story_base.data.model.InventoryDTO


interface InventoryLocalDataSource {
    fun fetchInventory(): List<InventoryDTO>
    fun fetchInventoryByPlaceId(placeId: Int): List<InventoryDTO>
    fun fetchInventoryById(id: Int): InventoryDTO?
}