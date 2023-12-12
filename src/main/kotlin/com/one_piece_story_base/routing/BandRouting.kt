package com.one_piece_story_base.routing

import com.one_piece_story_base.routing.repository.BandController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureBandRouting() {
    val band by inject<BandController>()
    routing {
        get("/band/place") {
            val id = call.request.queryParameters["placeId"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val bandPlace = id?.toInt()?.let { placeId -> band.getBandByPlace(placeId) }
            if (bandPlace == null)
                call.respond(status = HttpStatusCode.NotFound, "Band not found")
            else
                call.respond(status = HttpStatusCode.OK, bandPlace)
        }

        get("/band_description/place") {
            val id = call.request.queryParameters["placeId"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val bandPlace = id?.toInt()?.let { placeId -> band.getBandDescriptionByPlace(placeId) }
            if (bandPlace == null)
                call.respond(status = HttpStatusCode.NotFound, "Band not found")
            else
                call.respond(status = HttpStatusCode.OK, bandPlace)
        }

        get("/band_personage/place") {
            val id = call.request.queryParameters["placeId"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val bandPlace = id?.toInt()?.let { placeId -> band.getBandDescriptionByPlace(placeId) }
            if (bandPlace == null)
                call.respond(status = HttpStatusCode.NotFound, "Band not found")
            else
                call.respond(status = HttpStatusCode.OK, bandPlace)
        }
    }
}