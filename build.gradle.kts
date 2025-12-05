// build.gradle.kts

plugins {
    kotlin("jvm") version "2.2.21"
}

repositories {
    mavenCentral()
}

val junitVersion = "5.10.1"

dependencies {
    // Test API: Allows you to write @Test and use Assertions
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")

    // Test Engine: Provides the mechanism for running the tests (runtime dependency)
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")

    // Optional but highly recommended fix for the "Failed to load JUnit Platform" error
    testImplementation("org.junit.platform:junit-platform-launcher:1.10.1")
}

tasks.test {
    // CRITICAL: Activates the JUnit 5 test runner
    useJUnitPlatform()
}

tasks {
    wrapper {
        gradleVersion = "9.2.1"
    }
}