plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "io.github.libxposed"
    compileSdk = rootProject.extra["compileSdk"] as Int
    compileOptions {
        sourceCompatibility = rootProject.extra["javaVersion"] as JavaVersion
        targetCompatibility = rootProject.extra["javaVersion"] as JavaVersion
    }
}
