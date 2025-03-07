plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.mavenPublish)
    alias(libs.plugins.signing)
//    `maven-publish`
//    signing
}

android {
    namespace = "io.github.libxposed.api"
    compileSdk = rootProject.extra["compileSdk"] as Int
//    buildToolsVersion = "35.0.0"

    defaultConfig {
        minSdk = rootProject.extra["minSdk"] as Int
        consumerProguardFiles("proguard-rules.pro")
    }

    buildFeatures {
        androidResources = false
        buildConfig = false
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

dependencies {
    compileOnly(libs.androidx.annotation)
    lintPublish(project(":checks"))
}
