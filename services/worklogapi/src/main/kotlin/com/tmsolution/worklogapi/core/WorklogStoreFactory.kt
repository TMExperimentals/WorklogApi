package com.tmsolution.worklogapi.core

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.config.*
import io.ktor.server.engine.*
import org.jetbrains.exposed.sql.Database
import org.koin.java.KoinJavaComponent.inject
import org.koin.ktor.ext.inject


class WorklogStoreFactory() {

    private val environment: ApplicationConfig by inject(ApplicationConfig::class.java)
    fun init(){
        Database.connect(hikariInit())
    }

    private fun hikariInit(): HikariDataSource{


        val dbConfig = this.environment.config("ktor.database")
        val config = HikariConfig().apply {
            jdbcUrl = dbConfig.property("connection.jdbc").getString()
//            driverClassName = dbConfig.property("connection.driverClassName").getString()
            username = dbConfig.property("connection.user").getString()
            password = dbConfig.property("connection.password").getString()
            isAutoCommit = false
            println(dbConfig.property("connection.maximumPoolSize").getString())
            maximumPoolSize = dbConfig.property("connection.maximumPoolSize").getString().toInt()
            transactionIsolation = dbConfig.property("connection.transactionIsolation").getString()
            validate()
        }

        return HikariDataSource(config)
    }
}