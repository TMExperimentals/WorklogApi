package com.tmsolution.worklogapi.di

import com.tmsolution.worklogapi.config.env.EnvProperrties
import com.tmsolution.worklogapi.core.WorklogStoreFactory
import com.tmsolution.worklogapi.core.repositories.WorklogsRepository
import com.tmsolution.worklogapi.core.repositories.WorklogsRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.dsl.single

val singletons = module {
    // Backend Config
    singleOf<EnvProperrties> { EnvProperrties() }
    singleOf<WorklogStoreFactory> { WorklogStoreFactory() }
    singleOf<WorklogsRepository> { WorklogsRepositoryImpl() }
}