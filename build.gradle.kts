import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm") version "1.9.25"
    id("com.adarshr.test-logger") version "3.2.0"
    id("com.diffplug.spotless") version "6.25.0"
}

repositories {
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.13.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.platform:junit-platform-launcher")
    testImplementation("org.amshove.kluent:kluent:1.73")
}

sourceSets {
    test {
        java {
            srcDirs.add(File("src/test"))
        }
    }
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        events("failed")

        // log full stacktrace of failed test (assertion library descriptive error)
        exceptionFormat = TestExceptionFormat.FULL
    }
}

kotlin {
    jvmToolchain(19)
}

spotless {
    kotlin {
        target("test/com/igorwojda/**/*.kt")
        ktlint()

        indentWithSpaces()
        endWithNewline()
    }
}
