plugins {
    id("java")
}

group = "pactoria"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.7.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.2")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.12.7")

    compileOnly("org.immutables:value:2.10.1")
    compileOnly("org.immutables:builder:2.10.1")
    annotationProcessor("org.immutables:value:2.10.1")

    implementation("org.jetbrains:annotations:24.1.0")
}
