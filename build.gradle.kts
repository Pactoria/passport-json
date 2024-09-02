plugins {
    id("java")
    id("java-library")
    id("maven-publish")
}

var archivesBaseName = "passport-json"

repositories {
    mavenCentral()
}

java {
    withSourcesJar()
    withJavadocJar()
}

dependencies {
    api(project(":api"))
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.2")

    compileOnly("org.immutables:value:2.10.1")
    compileOnly("org.immutables:builder:2.10.1")
    annotationProcessor("org.immutables:value:2.10.1")
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")

    dependencies {
        implementation("com.fasterxml.jackson.core:jackson-databind:2.12.7.1")
        implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.12.7")
        implementation("org.jetbrains:annotations:24.1.0")
        compileOnly("com.google.code.findbugs:jsr305:3.0.1")
    }

    tasks.withType(JavaCompile::class.java) {
        options.encoding = "UTF-8"
        options.isIncremental = true
    }

    java {
        withSourcesJar()
        withJavadocJar()
    }
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
                "Automatic-Module-Name" to "pactoria.passport.json"
            )
        )
    }
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}