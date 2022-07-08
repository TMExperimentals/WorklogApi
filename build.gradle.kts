plugins {
    base
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
}

subprojects {
    apply {
        plugin("io.spring.dependency-management")
    }
    afterEvaluate {

        dependencyManagement {
            imports {
                mavenBom("io.ktor:ktor-bom:2.0.3")
                mavenBom("org.jetbrains.exposed:exposed-bom:0.38.2")
                mavenBom("org.jetbrains.kotlin:kotlin-bom:1.7.10")

            }

            dependencies {
                dependency("ch.qos.logback:logback-classic:1.2.11")
                dependency("com.zaxxer:HikariCP:5.0.1")
                dependency("com.microsoft.sqlserver:mssql-jdbc:10.2.1.jre17")
                dependency("com.h2database:h2:2.1.214")
                dependencySet("org.flywaydb:8.5.13") {
                    entry("flyway-core")
                    entry("flyway-sqlserver")
                }
                dependencySet("io.insert-koin:3.2.0") {
                    entry("koin-ktor")
                    entry("koin-logger-slf4j")
                }
            }
        }
    }
}
