package com.one_piece_story_base.routing

import com.one_piece_story_base.routing.repository.PersonageController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configurePersonageRouting() {
    val personage by inject<PersonageController>()
    routing {
        get("/personage") {
            call.respond(status = HttpStatusCode.OK, personage.getPersonage())
        }

        get("/personage/list") {
            call.respond(status = HttpStatusCode.OK, personage.getPersonageList())
        }

        get("/personage/place/list") {
            val id = call.request.queryParameters["id"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val personageMap = id?.toInt()?.let { placeId -> personage.getPersonageListByPlaceId(placeId) }
            if (personageMap == null)
                call.respond(status = HttpStatusCode.NotFound, "Personage not found")
            else
                call.respond(status = HttpStatusCode.OK, personageMap)
        }

        get("/personage/place") {
            val id = call.request.queryParameters["id"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val personageMap = id?.toInt()?.let { placeId -> personage.getPersonageByPlaceId(placeId) }
            if (personageMap == null)
                call.respond(status = HttpStatusCode.NotFound, "Personage not found")
            else
                call.respond(status = HttpStatusCode.OK, personageMap)
        }

        get("/personage_description/place") {
            val id = call.request.queryParameters["id"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val personageDescription =
                id?.toInt()?.let { placeId -> personage.getPersonageDescriptionByPlaceId(placeId) }
            if (personageDescription == null)
                call.respond(status = HttpStatusCode.NotFound, "Personage not found")
            else
                call.respond(status = HttpStatusCode.OK, personageDescription)
        }

        get("/personage_skill/place") {
            val id = call.request.queryParameters["id"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val personageSkill = id?.toInt()?.let { placeId -> personage.getSkillByPlaceId(placeId) }
            if (personageSkill == null)
                call.respond(status = HttpStatusCode.NotFound, "Skill not found")
            else
                call.respond(status = HttpStatusCode.OK, personageSkill)
        }

        get("/personage_weapon/place") {
            val id = call.request.queryParameters["id"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val personageWeapon = id?.toInt()?.let { placeId -> personage.getWeaponByPlaceId(placeId) }
            if (personageWeapon == null)
                call.respond(status = HttpStatusCode.NotFound, "Weapon not found")
            else
                call.respond(status = HttpStatusCode.OK, personageWeapon)
        }
    }
}