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
    }

    compileOptions {
        sourceCompatibility = rootProject.extra["javaVersion"] as JavaVersion
        targetCompatibility = rootProject.extra["javaVersion"] as JavaVersion
    }
}

dependencies {
//    implementation(project(":interface"))
    implementation(project(":library:libxposed:service:interface"))
    compileOnly(libs.androidx.annotation)
}
