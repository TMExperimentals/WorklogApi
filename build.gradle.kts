plugins{
    base
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

subprojects{
    apply {
        plugin("io.spring.dependency-management")
    }
    afterEvaluate {

        dependencyManagement{
            imports {
                mavenBom("org.jetbrains.kotlin:kotlin-bom:1.7.0")
            }
        }
    }
}