package com.tmsolution.worklogapi.plugins

import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.modules(){
    configureRouting()
    jwtAuthentication()

    install(Koin){
        slf4jLogger()
    }



}