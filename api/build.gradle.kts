var archivesBaseName = "passport-json-$project.name"

group = "pactoria.passport.json"

repositories {
    mavenCentral()
}

dependencies {
    api("com.fasterxml.jackson.core:jackson-databind:2.12.7.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.12.7")
}



publishing {
    publications {
        create("maven", MavenPublication::class) {
            from(components["java"])
            artifactId = archivesBaseName

            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeElements")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
        }
    }
}

tasks.jar {
    manifest {
        attributes(
            mapOf(
                "Implementation-Title" to archivesBaseName,
                "Implementation-Version" to version,
                "Automatic-Module-Name" to "pactoria.passport.json.api"
            )
        )
    }
}