package com.tmsolution.worklogapi

import com.tmsolution.worklogapi.plugins.jwtAuthentication
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main(args: Array<String>): Unit = EngineMain.main(args)