package com.tmsolution.worklogapi.store

interface WorklogStoreFactory {
    fun init()
    fun migrate()
}