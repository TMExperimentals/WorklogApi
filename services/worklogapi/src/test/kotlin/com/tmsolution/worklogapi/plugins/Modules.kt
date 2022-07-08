package com.tmsolution.worklogapi.plugins

import io.ktor.server.application.*
import io.ktor.server.locations.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

@OptIn(KtorExperimentalLocationsAPI::class)
fun Application.modules() {
    install(Koin) {
        slf4jLogger()
    }

    install(Locations)
    configureRouting()
}