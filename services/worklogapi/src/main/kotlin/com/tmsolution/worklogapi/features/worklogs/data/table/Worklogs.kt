package com.tmsolution.worklogapi.features.worklogs.data.table

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.Column

object Worklogs : UUIDTable(name = "WORKLOGS", columnName = "ID") {
    val TITLE: Column<String> = varchar("TITLE", 200)
}