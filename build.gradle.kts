plugins {
	kotlin("jvm") version "1.9.23"
	id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
}

group = "org.jtongay"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}