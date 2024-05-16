plugins {
    kotlin("jvm") version "1.9.23"
}

group = "com.abshka"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}