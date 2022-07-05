package com.tmsolution.worklogapi.plugins

import com.tmsolution.worklogapi.core.WorklogStoreFactory
import com.tmsolution.worklogapi.core.repositories.WorklogsRepository
import com.tmsolution.worklogapi.core.repositories.WorklogsRepositoryImpl
import com.typesafe.config.ConfigFactory
import io.ktor.server.application.*
import io.ktor.server.config.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.fileProperties
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger


val worklogModule = module {
    singleOf<WorklogStoreFactory> { WorklogStoreFactory(HoconApplicationConfig(ConfigFactory.load())) }
    singleOf<WorklogsRepository> { WorklogsRepositoryImpl() }

}

fun Application.modules(){

    configureRouting()
    jwtAuthentication()

    install(Koin){
        slf4jLogger()
        modules(worklogModule)
    }

    val store: WorklogStoreFactory by inject()
    store.init()

}