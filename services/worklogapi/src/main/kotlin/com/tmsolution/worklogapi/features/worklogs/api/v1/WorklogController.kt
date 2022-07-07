package com.tmsolution.worklogapi.features.worklogs.api.v1

import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

@OptIn(KtorExperimentalLocationsAPI::class)
@Location("v1")
class WorklogController {

    @Location("/test")
    class Test(val parent: WorklogController)
}

@OptIn(KtorExperimentalLocationsAPI::class)
fun Route.worklogController() {

    get<WorklogController.Test> {
        call.respondText("Hello World! from v1 worklog")
    }
}