package com.one_piece_story_base.database

import org.jetbrains.exposed.sql.Database

interface DatabaseFactory {
    fun connect(): Database
}