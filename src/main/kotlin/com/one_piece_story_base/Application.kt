package com.one_piece_story_base

import com.one_piece_story_base.database.DatabaseFactory
import com.one_piece_story_base.di.appModule
import com.one_piece_story_base.plugins.configureMonitoring
import com.one_piece_story_base.plugins.configureRouting
import com.one_piece_story_base.plugins.configureSerialization
import com.one_piece_story_base.routing.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun main() {

    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(Koin) {
        slf4jLogger()
        modules(appModule)
    }
    val databaseFactory by inject<DatabaseFactory>()
    databaseFactory.connect()
    configureSerialization()
    configureMonitoring()
    //   configureSecurity()
    configureRouting()
    configureMangaRouting()
    configurePlaceRouting()
    configurePersonageRouting()
    configureInventoryRouting()
    configureRewardRouting()
    configureBandRouting()
    configureBondRouting()
    configureFruitRouting()
    configureShipRouting()
    configureIslandRouting()
}

//const val BaseUrl = "http://127.0.0.1:8080/"
//const val BaseUrl = "http://10.0.2.2:8080/"
//const val BaseUrl = "http://192.168.1.59:8080/"
const val BaseUrl = "https://one-piece-backend.onrender.com/"
