package com.tmsolution.worklogapi.core.repositories

import com.tmsolution.worklogapi.core.models.WorkLog
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class WorklogsRepositoryImpl : WorklogsRepository {
    override suspend fun create(): Unit = newSuspendedTransaction {
        WorkLog.new {
            TITLE = ""
        }
    }

    override suspend fun fetch(): List<WorkLog> = newSuspendedTransaction {
        WorkLog.all().toList()
    }


}