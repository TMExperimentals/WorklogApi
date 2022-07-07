package com.tmsolution.worklogapi.di

import com.tmsolution.worklogapi.config.env.EnvProperrties
import com.tmsolution.worklogapi.features.worklogs.domain.repositories.WorklogsRepository
import com.tmsolution.worklogapi.features.worklogs.domain.repositories.WorklogsRepositoryImpl
import com.tmsolution.worklogapi.store.WorklogStoreFactory
import com.tmsolution.worklogapi.store.WorklogStoreFactoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val singletons = module {
    // Backend Config
    singleOf<EnvProperrties> { EnvProperrties() }
    singleOf<WorklogStoreFactory> { WorklogStoreFactoryImpl() }
    singleOf<WorklogsRepository> { WorklogsRepositoryImpl() }
}