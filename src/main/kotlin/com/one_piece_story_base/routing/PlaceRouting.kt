package com.one_piece_story_base.routing

import com.one_piece_story_base.routing.repository.PlaceController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configurePlaceRouting() {
    val place by inject<PlaceController>()

    routing {

        get("/place") {
            val id = call.request.queryParameters["id"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val placeMap = id?.toInt()?.let { placeId -> place.getPlaceById(placeId) }
            if (placeMap == null)
                call.respond(status = HttpStatusCode.NotFound, "Place not found")
            else
                call.respond(status = HttpStatusCode.OK, placeMap)
        }

        get("/place_description") {
            val id = call.request.queryParameters["id"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val placeDescription = id?.toInt()?.let { placeId -> place.getPlaceDescriptionById(placeId) }
            if (placeDescription == null)
                call.respond(status = HttpStatusCode.NotFound, "Place not found")
            else
                call.respond(status = HttpStatusCode.OK, placeDescription)
        }

        get("/place_item") {
            val id = call.request.queryParameters["id"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val placeItem = id?.toInt()?.let { placeId -> place.getPlaceItemById(placeId) }
            if (placeItem == null)
                call.respond(status = HttpStatusCode.NotFound, "Item not found")
            else
                call.respond(status = HttpStatusCode.OK, placeItem)
        }

        get("/place_transit") {
            val id = call.request.queryParameters["id"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val placeTransit = id?.toInt()?.let { placeId -> place.getTransitItemById(placeId) }
            if (placeTransit == null)
                call.respond(status = HttpStatusCode.NotFound, "Transit not found")
            else
                call.respond(status = HttpStatusCode.OK, placeTransit)
        }

        get("/manga/place") {
            call.respond(status = HttpStatusCode.OK, place.getAllMangaPlace())
        }

        get("/maps") {
            call.respond(status = HttpStatusCode.OK, place.getMapPlace())
        }

        get("/map") {
            val id = call.request.queryParameters["id"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val placeMap = id?.toInt()?.let { placeId -> place.getMapPlaceById(placeId) }
            if (placeMap == null)
                call.respond(status = HttpStatusCode.NotFound, "Place not found")
            else
                call.respond(status = HttpStatusCode.OK, placeMap)
        }
    }
}