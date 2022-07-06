package com.tmsolution.worklogapi.core

import com.microsoft.sqlserver.jdbc.SQLServerDataSource
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.config.*
import io.ktor.server.engine.*
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.koin.java.KoinJavaComponent.inject
import org.koin.ktor.ext.inject
import javax.sql.DataSource


class WorklogStoreFactory() {

    private val environment: ApplicationConfig by inject(ApplicationConfig::class.java)
    lateinit var hikariDataConfig: HikariDataSource
    fun init(){
        hikariInit()
        Database.connect(hikariDataConfig)
        migrate()
    }

    private fun hikariInit(){
        val dbConfig = this.environment.config("ktor.database")

        val dataSourceSQL: DataSource = SQLServerDataSource().apply {
            url = dbConfig.property("connection.jdbc").getString()
            user = dbConfig.property("connection.user").getString()
            setPassword(dbConfig.property("connection.password").getString())
        }

        val hikariConfig = HikariConfig().apply {
            dataSource = dataSourceSQL
            driverClassName = dbConfig.property("connection.driverClassName").getString()
            isAutoCommit = false
            println(dbConfig.property("connection.maximumPoolSize").getString())
            maximumPoolSize = dbConfig.property("connection.maximumPoolSize").getString().toInt()
            transactionIsolation = dbConfig.property("connection.transactionIsolation").getString()
            validate()
        }

        this.hikariDataConfig = HikariDataSource(hikariConfig)
    }
    private fun migrate(){
        Flyway.configure().baselineOnMigrate(true).dataSource(hikariDataConfig.dataSource).load().migrate()
    }
}