package com.one_piece_story_base.database

import org.jetbrains.exposed.sql.Database


class DatabaseFactoryImpl : DatabaseFactory {
//    private val host = System.getenv("DB_HOST") ?: "localhost"
//    private val port = System.getenv("DB_PORT")?.toIntOrNull() ?: 5432
//    private val dbName = System.getenv("DB_NAME") ?: "one_piece_base"
//    private val dbUser = System.getenv("DB_USER") ?: "postgres"
//    private val dbPassword = System.getenv("DB_PASSWORD") ?: "-^DeFey270988^-"

    private val host = System.getenv("DB_HOST") ?: "dpg-clsn9jdcm5oc73b8m4tg-a.frankfurt-postgres.render.com"
    private val port = System.getenv("DB_PORT")?.toIntOrNull() ?: 5432
    private val dbName = System.getenv("DB_NAME") ?: "one_piece_database"
    private val dbUser = System.getenv("DB_USER") ?: "one_piece_database_user"
    private val dbPassword = System.getenv("DB_PASSWORD") ?: "fGYJguoMt4rj1m6pkaVWPvR8dokMML1W"
    override fun connect() = Database.connect(
        url = "jdbc:postgresql://$host:$port/$dbName",
        driver = "org.postgresql.Driver",
        user = dbUser,
        password = dbPassword,
    )
}