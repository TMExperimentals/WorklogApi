package com.tmsolution.worklogapi.core.dao

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class WorklogDAO(val db: Database) : WorklogInterface {
    override fun init() = transaction(db) {
        SchemaUtils.create(Worklogs)
    }

    override fun close() {
        TODO("Not yet implemented")
    }

}