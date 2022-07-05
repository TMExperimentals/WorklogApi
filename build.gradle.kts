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
                mavenBom("org.jetbrains.kotlin:kotlin-bom:1.7.0")
            }

            dependencies {
                dependency("ch.qos.logback:logback-classic:1.2.11")
                dependencySet("io.insert-koin:3.2.0"){
                    entry("koin-ktor")
                    entry("koin-logger-slf4j")
            }
        }
    }
}