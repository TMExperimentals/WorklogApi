package com.tmsolution.worklogapi.core

import com.microsoft.sqlserver.jdbc.SQLServerDataSource
import com.tmsolution.worklogapi.config.env.EnvProperrties
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

    private val environment: EnvProperrties by inject(EnvProperrties::class.java)
    lateinit var hikariDataConfig: HikariDataSource
    fun init(){
        hikariInit()
        Database.connect(hikariDataConfig)
        migrate()
    }

    private fun hikariInit(){


        val dataSourceSQL: DataSource = SQLServerDataSource().apply {
            url = environment.dbConfig.URL
            user = environment.dbConfig.USER
            setPassword(environment.dbConfig.PASSWORD)
        }

        val hikariConfig = HikariConfig().apply {
            dataSource = dataSourceSQL
            driverClassName = environment.dbConfig.DRIVER_CLASS
            isAutoCommit = false
            maximumPoolSize = environment.dbConfig.MAX_POOL
            transactionIsolation = environment.dbConfig.TRANSACTION_ISOLATION
            validate()
        }

        this.hikariDataConfig = HikariDataSource(hikariConfig)
    }
    private fun migrate(){
        Flyway.configure().baselineOnMigrate(true).dataSource(hikariDataConfig.dataSource).load().migrate()
    }
}