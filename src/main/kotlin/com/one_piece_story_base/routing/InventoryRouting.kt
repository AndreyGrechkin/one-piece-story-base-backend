package com.one_piece_story_base.routing

import com.one_piece_story_base.routing.repository.InventoryController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureInventoryRouting() {
    val inventory by inject<InventoryController>()
    routing {
        get("/inventory") {
            call.respond(status = HttpStatusCode.OK, inventory.getAllInventory())
        }

        get("/inventory/place") {
            val id = call.request.queryParameters["placeId"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val inventoryPlace = id?.toInt()?.let { placeId -> inventory.getInventoryByPlaceId(placeId) }
            if (inventoryPlace == null)
                call.respond(status = HttpStatusCode.NotFound, "Inventory not found")
            else
                call.respond(status = HttpStatusCode.OK, inventoryPlace)
        }
    }
}