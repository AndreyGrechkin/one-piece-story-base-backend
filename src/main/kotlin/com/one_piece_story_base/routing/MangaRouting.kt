package com.one_piece_story_base.routing

import com.one_piece_story_base.routing.repository.MangaController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Application.configureMangaRouting() {
    val manga by inject<MangaController>()

    routing {
        get("/manga") {
            call.respond(status = HttpStatusCode.OK, manga.getMangaAll())
        }

        get("/manga/place") {
            val id = call.request.queryParameters["placeId"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val mangaPlace = id?.toInt()?.let { placeId -> manga.getMangaByPlace(placeId) }
            if (mangaPlace == null)
                call.respond(status = HttpStatusCode.NotFound, "Manga not found")
            else
                call.respond(status = HttpStatusCode.OK, mangaPlace)
        }
    }
}