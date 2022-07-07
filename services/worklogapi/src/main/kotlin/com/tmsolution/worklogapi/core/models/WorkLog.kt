package com.tmsolution.worklogapi.core.models

import com.tmsolution.worklogapi.core.dao.Worklogs
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class WorkLog(ID: EntityID<UUID>) : UUIDEntity(ID) {
    companion object : UUIDEntityClass<WorkLog>(Worklogs)

    var TITLE by Worklogs.TITLE
}
