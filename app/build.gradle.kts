plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.lsplugin.jgit)
    alias(libs.plugins.lsplugin.apksign)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.dinesh"
    compileSdk = rootProject.extra["compileSdk"] as Int

    defaultConfig {
        applicationId = "com.dinesh"
        minSdk = rootProject.extra["minSdk"] as Int
        targetSdk = rootProject.extra["targetSdk"] as Int
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = rootProject.extra["javaVersion"] as JavaVersion
        targetCompatibility = rootProject.extra["javaVersion"] as JavaVersion
    }
//    kotlinOptions {
////        jvmTarget = "17"
//        jvmTarget = (rootProject.extra["jvmToolchain"] as Int).toString()
//    }
    kotlin {
        jvmToolchain(rootProject.extra["jvmToolchain"] as Int)
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
}

dependencies {
    compileOnly(project(":libxposed-compat"))

    compileOnly(project(":api"))    //  https://github.com/libxposed/api.git
    compileOnly(project(":checks")) //  https://github.com/libxposed/api.git

    compileOnly(project(":service"))    //  https://github.com/libxposed/service.git
    implementation(project(":interface"))   //  https://github.com/libxposed/service.git

//    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
//    implementation("androidx.activity:activity-ktx:1.10.0")


//    implementation(libs.androidx.lifecycle.runtimeKtx)
//    implementation(libs.androidx.activity.compose)
//    implementation(platform(libs.androidx.compose.bom))
//    implementation(libs.androidx.compose.material3)
//    implementation(libs.androidx.compose.animation.core.android)
//    implementation(libs.androidx.compose.animation.android)
//    implementation(libs.androidx.compose.ui)
//    implementation(libs.androidx.compose.ui.graphics)
//    implementation(libs.accompanist.drawablepainter)

//    compileOnly("io.github.libxposed:api:100")
//    implementation("io.github.libxposed:service:100-1.0.0")

//    compileOnly("de.robv.android.xposed:api:82")

    compileOnly("de.robv.android.xposed:api:82")
    compileOnly("de.robv.android.xposed:api:82:sources")



    implementation(libs.hiddenapibypass)



//    implementation("androidx.core:core-ktx:1.15.0") // coreKtx
//    testImplementation("junit:junit:4.13.2") // junit
//    androidTestImplementation("androidx.test.ext:junit:1.2.1") // junitVersion
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1") // espressoCore
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7") // lifecycleRuntimeKtx
//    implementation("androidx.activity:activity-compose:1.10.1") // activityCompose
//    implementation(platform("androidx.compose:compose-bom:2024.09.00")) // composeBom
//    implementation("androidx.compose.ui:ui") // androidx-ui
//    implementation("androidx.compose.ui:ui-graphics") // androidx-ui-graphics
//    implementation("androidx.compose.ui:ui-tooling") // androidx-ui-tooling
//    implementation("androidx.compose.ui:ui-tooling-preview") // androidx-ui-tooling-preview
//    androidTestImplementation("androidx.compose.ui:ui-test-manifest") // androidx-ui-test-manifest
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4") // androidx-ui-test-junit4
//    implementation("androidx.compose.material3:material3") // androidx-material3


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

}


/*
[versions]
agp = "8.9.0"
kotlin = "2.0.21"
coreKtx = "1.15.0"
junit = "4.13.2"
junitVersion = "1.2.1"
espressoCore = "3.6.1"
lifecycleRuntimeKtx = "2.8.7"
activityCompose = "1.10.1"
composeBom = "2024.09.00"

[libraries]
androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "coreKtx" }
junit = { group = "junit", name = "junit", version.ref = "junit" }
androidx-junit = { group = "androidx.test.ext", name = "junit", version.ref = "junitVersion" }
androidx-espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "espressoCore" }
androidx-lifecycle-runtime-ktx = { group = "androidx.lifecycle", name = "lifecycle-runtime-ktx", version.ref = "lifecycleRuntimeKtx" }
androidx-activity-compose = { group = "androidx.activity", name = "activity-compose", version.ref = "activityCompose" }
androidx-compose-bom = { group = "androidx.compose", name = "compose-bom", version.ref = "composeBom" }
androidx-ui = { group = "androidx.compose.ui", name = "ui" }
androidx-ui-graphics = { group = "androidx.compose.ui", name = "ui-graphics" }
androidx-ui-tooling = { group = "androidx.compose.ui", name = "ui-tooling" }
androidx-ui-tooling-preview = { group = "androidx.compose.ui", name = "ui-tooling-preview" }
androidx-ui-test-manifest = { group = "androidx.compose.ui", name = "ui-test-manifest" }
androidx-ui-test-junit4 = { group = "androidx.compose.ui", name = "ui-test-junit4" }
androidx-material3 = { group = "androidx.compose.material3", name = "material3" }

[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
kotlin-compose = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }



 */






/*
[versions]
androidGradlePlugin = "8.8.2"
kotlin = "2.1.10"
lifecycleRuntimeKtx = "2.8.7"
activityCompose = "1.10.1"
composeBom = "2025.02.00"
accompanistDrawablepainter = "0.37.2"
libxposed = "100"
libxposedService = "100-1.0.0"
xposed = "82"
hiddenapibypass = "6.1"
androidxAnnotation = "1.9.1"
lint = "31.8.2"
kotlinStdlib = "2.1.10"
lspluginJgit = "1.1"
lspluginApksign = "1.4"

[libraries]
androidx-lifecycle-runtimeKtx = { module = "androidx.lifecycle:lifecycle-runtime-ktx", version.ref = "lifecycleRuntimeKtx" }
androidx-activity-compose = { module = "androidx.activity:activity-compose", version.ref = "activityCompose" }
androidx-compose-bom = { module = "androidx.compose:compose-bom", version.ref = "composeBom" }
androidx-compose-material3 = { module = "androidx.compose.material3:material3" }
androidx-compose-animation-core-android = { module = "androidx.compose.animation:animation-core-android", version = "1.7.8" }
androidx-compose-animation-android = { module = "androidx.compose.animation:animation-android", version = "1.7.8" }
androidx-compose-ui = { module = "androidx.compose.ui:ui" }
androidx-compose-ui-graphics = { module = "androidx.compose.ui:ui-graphics" }
accompanist-drawablepainter = { module = "com.google.accompanist:accompanist-drawablepainter", version.ref = "accompanistDrawablepainter" }
libxposed-api = { module = "io.github.libxposed:api", version.ref = "libxposed" }
libxposed-service = { module = "io.github.libxposed:service", version.ref = "libxposedService" }
xposed-api = { module = "de.robv.android.xposed:api", version.ref = "xposed" }
xposed-api-sources = { module = "de.robv.android.xposed:api", version.ref = "xposed" }
hiddenapibypass = { module = "org.lsposed.hiddenapibypass:hiddenapibypass", version.ref = "hiddenapibypass" }
androidx-annotation = { module = "androidx.annotation:annotation", version.ref = "androidxAnnotation" }
lint-api = { module = "com.android.tools.lint:lint-api", version.ref = "lint" }
lint-checks = { module = "com.android.tools.lint:lint-checks", version.ref = "lint" }
kotlin-stdlib = { module = "org.jetbrains.kotlin:kotlin-stdlib", version.ref = "kotlinStdlib" }

[plugins]
android-application = { id = "com.android.application", version.ref = "androidGradlePlugin" }
android-library = { id = "com.android.library", version.ref = "androidGradlePlugin" }
kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
kotlin-compose = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }
lsplugin-jgit = { id = "org.lsposed.lsplugin.jgit", version.ref = "lspluginJgit" }
lsplugin-apksign = { id = "org.lsposed.lsplugin.apksign", version.ref = "lspluginApksign" }
mavenPublish = { id = "maven-publish" }
signing = { id = "signing" }

 */