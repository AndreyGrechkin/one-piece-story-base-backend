package com.one_piece_story_base.routing

import com.one_piece_story_base.routing.repository.IslandController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureIslandRouting() {
    val island by inject<IslandController>()

    routing {
        get ("/islands") {
            call.respond(status = HttpStatusCode.OK, island.getIsland())
        }

        get ("/islands/personage") {
            val id = call.request.queryParameters["placeId"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val coordinateIsland = id?.toInt()?.let { placeId -> island.getPersonageIsland(placeId) }
            if (coordinateIsland == null)
                call.respond(status = HttpStatusCode.NotFound, "Inventory not found")
            else
                call.respond(status = HttpStatusCode.OK, coordinateIsland)
        }

        get ("/islands/transit") {
            val id = call.request.queryParameters["placeId"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val transitIsland = id?.toInt()?.let { placeId -> island.getIslandTransit(placeId) }
            if (transitIsland == null)
                call.respond(status = HttpStatusCode.NotFound, "Inventory not found")
            else
                call.respond(status = HttpStatusCode.OK, transitIsland)
        }
    }
}