package com.one_piece_story_base.plugins

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello OnePiece StoryBase")
        }
        static("/static") {
            resources("static")
        }
    }
}
