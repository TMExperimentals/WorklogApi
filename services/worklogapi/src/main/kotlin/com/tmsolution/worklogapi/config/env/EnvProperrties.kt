package com.tmsolution.worklogapi.config.env

import io.ktor.server.application.*
import org.koin.ktor.ext.inject

class EnvProperrties {
    lateinit var dbConfig: DBConfig
}

fun Application.setupENV(){
    val envProperties: EnvProperrties by inject<EnvProperrties>()

    val dbConfig = environment.config.config("ktor.database")
    envProperties.dbConfig = DBConfig(
        URL = dbConfig.property("connection.jdbc").getString(),
        USER = dbConfig.property("connection.user").getString(),
        PASSWORD = dbConfig.property("connection.password").getString(),
        DRIVER_CLASS = dbConfig.property("connection.driverClassName").getString(),
        TRANSACTION_ISOLATION = dbConfig.property("connection.transactionIsolation").getString(),
        MAX_POOL = dbConfig.property("connection.maximumPoolSize").getString().toInt()
    )
}