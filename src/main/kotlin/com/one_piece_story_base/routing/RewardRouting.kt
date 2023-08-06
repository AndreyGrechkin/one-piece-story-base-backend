package com.one_piece_story_base.routing

import com.one_piece_story_base.routing.repository.RewardController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRewardRouting() {
    val reward by inject<RewardController>()

    routing {
        get("/reward") {
            call.respond(status = HttpStatusCode.OK, reward.getAllReward())
        }

        get("/reward/single") {
            val id = call.request.queryParameters["id"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val rewardById = id?.toInt()?.let { rewardId -> reward.getRewardById(rewardId) }
            if (rewardById == null)
                call.respond(status = HttpStatusCode.NotFound, "Reward not found")
            else
                call.respond(status = HttpStatusCode.OK, rewardById)
        }

        get("/reward/place") {
            val id = call.request.queryParameters["placeId"]
            if (id.isNullOrEmpty())
                call.respond(status = HttpStatusCode.BadRequest, "Not query parameter")
            val rewardPlace = id?.toInt()?.let { placeId -> reward.getAllRewardPlace(placeId) }
            if (rewardPlace == null)
                call.respond(status = HttpStatusCode.NotFound, "Reward not found")
            else
                call.respond(status = HttpStatusCode.OK, rewardPlace)
        }
    }
}