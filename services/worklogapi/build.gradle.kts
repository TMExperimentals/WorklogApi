plugins{
    application
    id("com.github.johnrengelman.shadow") version "7.1.2"
    kotlin("jvm") version "1.7.10"
}

application{
    mainClass.set("com.tmsolution.worklogapi.ApplicationKt")
}

tasks{
    jar{
        manifest {
            attributes(mapOf(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version,
                "Main-Class" to "com.tmsolution.worklogapi.ApplicationKt"
            ))
        }

    }
}


dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("io.ktor:ktor-server-auth-jvm")
    implementation("io.ktor:ktor-server-auth-jwt-jvm")
    implementation("io.ktor:ktor-server-locations-jvm")
    implementation("io.ktor:ktor-serialization-jackson-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")

    implementation("io.insert-koin:koin-ktor")
    implementation("io.insert-koin:koin-logger-slf4j")

    implementation("ch.qos.logback:logback-classic")

    implementation("org.jetbrains.exposed:exposed-core")
    implementation("org.jetbrains.exposed:exposed-dao")
    implementation("org.jetbrains.exposed:exposed-jdbc")

    implementation("com.zaxxer:HikariCP")
    implementation("com.microsoft.sqlserver:mssql-jdbc")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-sqlserver")

    testImplementation("io.ktor:ktor-server-test-host-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("com.h2database:h2")


}