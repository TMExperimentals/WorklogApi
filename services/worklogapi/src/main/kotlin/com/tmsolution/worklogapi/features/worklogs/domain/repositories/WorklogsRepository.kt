package com.tmsolution.worklogapi.features.worklogs.domain.repositories

import com.tmsolution.worklogapi.core.models.WorkLog

interface WorklogsRepository {
    suspend fun create()
    suspend fun fetch(): List<WorkLog>
}