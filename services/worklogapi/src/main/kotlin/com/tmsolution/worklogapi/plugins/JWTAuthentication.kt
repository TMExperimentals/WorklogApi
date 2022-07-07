package com.tmsolution.worklogapi.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*

fun Application.jwtAuthentication() {

    val secret = environment.config.property("jwt.secret").getString()
    install(Authentication) {
        // Configure jwt authentication
        jwt("auth-jwt") {
            realm = "Access to hello"
            verifier(
                JWT.require(Algorithm.HMAC256(secret)).build()
            )
            validate { credential ->
                JWTPrincipal(credential.payload)
            }
        }

    }
}