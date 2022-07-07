package com.tmsolution.worklogapi.config.env

data class DBConfig(
    val URL: String,
    val DRIVER_CLASS: String,
    val USER: String,
    val PASSWORD: String,
    val TRANSACTION_ISOLATION: String,
    val MAX_POOL: Int
)
