package com.tmsolution.worklogapi.core.dao

import io.ktor.utils.io.core.*

interface WorklogInterface : Closeable {
    fun init()
}