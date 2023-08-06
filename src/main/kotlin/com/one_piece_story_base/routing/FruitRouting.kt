package com.one_piece_story_base.routing

import com.one_piece_story_base.routing.repository.BondController
import com.one_piece_story_base.routing.repository.FruitController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureFruitRouting() {
    val fruit by inject<FruitController>()
    routing {
        get("/fruit/place") {
            val id = call.request.queryParameters["placeId"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val fruitPlace = id?.toInt()?.let { placeId -> fruit.getFruitByPlace(placeId) }
            if (fruitPlace == null)
                call.respond(status = HttpStatusCode.NotFound, "Bond not found")
            else
                call.respond(status = HttpStatusCode.OK, fruitPlace)
        }
    }
}