package com.tmsolution.worklogapi.plugins

import com.tmsolution.worklogapi.config.env.setupENV
import com.tmsolution.worklogapi.di.singletons
import com.tmsolution.worklogapi.store.WorklogStoreFactory
import io.ktor.server.application.*
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.modules() {

    install(Koin) {
        slf4jLogger()
        modules(singletons)
    }

    setupENV()
    configureRouting()
    jwtAuthentication()

    val store: WorklogStoreFactory by inject()
    store.init()

}