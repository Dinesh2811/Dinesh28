plugins {
    java
}

java {
    sourceCompatibility = rootProject.extra["javaVersion"] as JavaVersion
    targetCompatibility = rootProject.extra["javaVersion"] as JavaVersion
}

dependencies {
    compileOnly(libs.lint.api)
    compileOnly(libs.lint.checks)
    compileOnly(libs.kotlin.stdlib)
}

