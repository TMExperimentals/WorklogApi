package com.tmsolution.worklogapi.core.repositories

import com.tmsolution.worklogapi.core.dao.Worklogs
import com.tmsolution.worklogapi.core.models.WorkLog

interface WorklogsRepository {
    suspend fun create()
    suspend fun fetch(): List<WorkLog>
}