package com.tmsolution.worklogapi.features.worklogs.data.entities

import com.tmsolution.worklogapi.core.dao.Worklogs
import com.tmsolution.worklogapi.core.models.WorkLog
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class Worklog(ID: EntityID<UUID>) : UUIDEntity(ID) {
    companion object : UUIDEntityClass<WorkLog>(Worklogs)

    var TITLE by Worklogs.TITLE
}