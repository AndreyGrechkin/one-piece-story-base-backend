package com.one_piece_story_base.routing

import com.one_piece_story_base.routing.repository.BondController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureBondRouting() {
    val bond by inject<BondController>()
    routing {
        get("/bond/place"){
            val id = call.request.queryParameters["placeId"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val bondPlace = id?.toInt()?.let { placeId -> bond.getBondByPlace(placeId) }
            if (bondPlace == null)
                call.respond(status = HttpStatusCode.NotFound, "Bond not found")
            else
                call.respond(status = HttpStatusCode.OK, bondPlace)
        }
    }
}