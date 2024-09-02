plugins {
    id("java")
    id("maven-publish")
}

var archivesBaseName = "passport-json-$project.name"

group = "pactoria.passport.json"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.7.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.12.7")
}

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create("maven", MavenPublication::class) {
            from(components["java"])
            artifactId = archivesBaseName
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