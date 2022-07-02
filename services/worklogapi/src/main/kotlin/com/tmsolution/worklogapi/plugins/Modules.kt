package com.tmsolution.worklogapi.plugins

import io.ktor.server.application.*

fun Application.modules(){
    configureRouting()
    jwtAuthentication()
}