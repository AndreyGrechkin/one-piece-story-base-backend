package com.one_piece_story_base.routing

import com.one_piece_story_base.routing.repository.ShipController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureShipRouting() {

    val ship by inject<ShipController>()

    routing {
        get("/ship/place") {
            val id = call.request.queryParameters["placeId"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val shipPlace = id?.toInt()?.let { placeId -> ship.getShipByPlace(placeId) }
            if (shipPlace == null)
                call.respond(status = HttpStatusCode.NotFound, "Ship not found")
            else
                call.respond(status = HttpStatusCode.OK, shipPlace)
        }
    }
}