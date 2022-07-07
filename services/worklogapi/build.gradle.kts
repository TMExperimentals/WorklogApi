plugins {
    kotlin("jvm") version "1.7.0"
}

dependencies {
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-netty")
    implementation("io.ktor:ktor-server-auth")
    implementation("io.ktor:ktor-server-auth-jwt")
    implementation("io.ktor:ktor-server-locations")

//    implementation("io.ktor:ktor-jackson")
    implementation("io.ktor:ktor-server-content-negotiation")

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

    testImplementation("io.ktor:ktor-server-test-host")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("com.h2database:h2")


}