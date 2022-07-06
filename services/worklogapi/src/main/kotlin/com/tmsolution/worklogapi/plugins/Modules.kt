package com.tmsolution.worklogapi.plugins

import com.tmsolution.worklogapi.core.WorklogStoreFactory
import com.tmsolution.worklogapi.core.repositories.WorklogsRepository
import com.tmsolution.worklogapi.core.repositories.WorklogsRepositoryImpl
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

    val worklogModule = module {
        singleOf<ApplicationConfig> { environment.config }
        singleOf<WorklogStoreFactory> { WorklogStoreFactory() }
        singleOf<WorklogsRepository> { WorklogsRepositoryImpl() }
    }

    configureRouting()
    jwtAuthentication()

    install(Koin){
        slf4jLogger()
        modules(worklogModule)
    }

    val store: WorklogStoreFactory by inject()
    store.init()

}