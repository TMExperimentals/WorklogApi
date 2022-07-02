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
            }

            dependencies {
                dependency("ch.qos.logback:logback-classic:1.2.3")
            }
        }
    }
}