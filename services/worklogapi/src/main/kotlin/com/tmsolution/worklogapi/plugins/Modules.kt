package com.tmsolution.worklogapi.plugins

import com.tmsolution.worklogapi.config.env.setupENV
import com.tmsolution.worklogapi.core.WorklogStoreFactory
import com.tmsolution.worklogapi.core.repositories.WorklogsRepository
import com.tmsolution.worklogapi.core.repositories.WorklogsRepositoryImpl
import com.tmsolution.worklogapi.di.singletons
import com.typesafe.config.ConfigFactory
import io.ktor.server.application.*
import io.ktor.server.config.*
import org.flywaydb.core.Flyway
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.fileProperties
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.modules(){

    install(Koin){
        slf4jLogger()
        modules(singletons)
    }

    setupENV()
    configureRouting()
    jwtAuthentication()

    val store: WorklogStoreFactory by inject()
    store.init()

}