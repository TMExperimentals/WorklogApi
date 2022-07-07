package com.tmsolution.worklogapi.features.worklogs.data.entities

import com.tmsolution.worklogapi.features.worklogs.data.table.Worklogs
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class Worklog(ID: EntityID<UUID>) : UUIDEntity(ID) {
    companion object : UUIDEntityClass<Worklog>(Worklogs)

    var TITLE by Worklogs.TITLE
}