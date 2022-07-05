package com.tmsolution.worklogapi.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.modules(){
    configureRouting()
    jwtAuthentication()
    install(ContentNegotiation){
    }

    install(Koin){
        slf4jLogger()
    }



}