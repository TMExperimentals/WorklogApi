package com.tmsolution.worklogapi.core.dao

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Worklogs : UUIDTable(name = "WORKLOGS", columnName = "ID") {
    val TITLE:Column<String> = varchar("TITLE", 200)
}