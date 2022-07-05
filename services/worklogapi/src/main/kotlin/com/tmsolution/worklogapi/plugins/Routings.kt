package com.tmsolution.worklogapi.plugins

import com.tmsolution.worklogapi.core.repositories.WorklogsRepository
import com.tmsolution.worklogapi.core.repositories.WorklogsRepositoryImpl
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    val worklogsRepository: WorklogsRepository by inject()
    // Starting point for a Ktor app:
    routing {
//        authenticate("auth-jwt") {
//
//        }

        get("/") {
            val test = worklogsRepository.fetch();
        }

    }
}
