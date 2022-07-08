package com.tmsolution.worklogapi.plugins

import com.fasterxml.jackson.databind.SerializationFeature
import com.tmsolution.worklogapi.config.env.setupENV
import com.tmsolution.worklogapi.di.singletons
import com.tmsolution.worklogapi.store.WorklogStoreFactory
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.plugins.contentnegotiation.*
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

@OptIn(KtorExperimentalLocationsAPI::class)
fun Application.modules() {

    install(Koin) {
        slf4jLogger()
        modules(singletons)
    }

    install(ContentNegotiation) {
        jackson {
            configure(SerializationFeature.INDENT_OUTPUT, true)
        }
    }

    setupENV()
    jwtAuthentication()

    val store: WorklogStoreFactory by inject()
    store.init()

    install(Locations)
    configureRouting()

}