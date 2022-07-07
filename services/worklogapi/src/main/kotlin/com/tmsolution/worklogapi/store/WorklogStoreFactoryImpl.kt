package com.tmsolution.worklogapi.store

import com.microsoft.sqlserver.jdbc.SQLServerDataSource
import com.tmsolution.worklogapi.config.env.EnvProperrties
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.koin.java.KoinJavaComponent.inject
import javax.sql.DataSource

class WorklogStoreFactoryImpl : WorklogStoreFactory {

    private val environment: EnvProperrties by inject(EnvProperrties::class.java)
    private lateinit var hikariDataConfig: HikariDataSource

    override fun init() {
        hikariInit()
        Database.connect(hikariDataConfig)
        migrate()
    }

    private fun hikariInit() {

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

    override fun migrate() {
        Flyway.configure().baselineOnMigrate(true).dataSource(hikariDataConfig.dataSource).load().migrate()
    }
}