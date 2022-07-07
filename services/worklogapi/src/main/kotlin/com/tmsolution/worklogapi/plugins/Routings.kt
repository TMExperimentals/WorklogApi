package com.tmsolution.worklogapi.plugins

import com.tmsolution.worklogapi.features.worklogs.api.v1.worklogController
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
//        authenticate("auth-jwt") {
//
//        }

        worklogController()
        get("/") {
            call.respondText("Hello World!")
        }

    }
}
