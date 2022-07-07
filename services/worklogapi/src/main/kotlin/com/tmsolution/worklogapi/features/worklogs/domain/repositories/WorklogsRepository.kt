package com.tmsolution.worklogapi.features.worklogs.domain.repositories

import com.tmsolution.worklogapi.features.worklogs.data.entities.Worklog

interface WorklogsRepository {
    suspend fun create()
    suspend fun fetch(): List<Worklog>
}