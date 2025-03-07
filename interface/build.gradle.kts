plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.mavenPublish)
    alias(libs.plugins.signing)
//    id("maven-publish")
//    id("signing")
}

android {
    namespace = "io.github.libxposed.service"
    compileSdk = rootProject.extra["compileSdk"] as Int
//    buildToolsVersion = "34.0.0"

    defaultConfig {
        minSdk = rootProject.extra["minSdk"] as Int
    }

    buildFeatures {
        buildConfig = false
        resValues = false
        aidl = true
    }

    compileOptions {
        targetCompatibility = rootProject.extra["javaVersion"] as JavaVersion
        sourceCompatibility = rootProject.extra["javaVersion"] as JavaVersion
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}
