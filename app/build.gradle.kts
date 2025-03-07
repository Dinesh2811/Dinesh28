plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.lsplugin.jgit)
    alias(libs.plugins.lsplugin.apksign)
    alias(libs.plugins.compose)
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

//    compileOnly("io.github.libxposed:api:100")
//    implementation("io.github.libxposed:service:100-1.0.0")

    compileOnly("de.robv.android.xposed:api:82")
    compileOnly("de.robv.android.xposed:api:82:sources")

    implementation(libs.hiddenapibypass)


////    implementation("androidx.core:core-ktx:1.15.0")
//    implementation("androidx.appcompat:appcompat:1.7.0")
////    implementation("androidx.activity:activity-ktx:1.10.0")

    implementation(libs.bundles.android)
    implementation(libs.bundles.compose)
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))

    //  ViewModel & LiveData
    implementation(libs.bundles.lifecycle)

//    //  Room components
//    implementation(libs.bundles.room)
//    ksp(libs.androidx.room.compiler)    //  kapt or ksp
//
//    // Glide
//    implementation(libs.glide)
//    annotationProcessor(libs.compiler)
//
//    // Retrofit
//    implementation(libs.bundles.retrofit)
//
//    // Gson
//    implementation(libs.bundles.gson)
//
//    // Serialization
//    implementation(libs.bundles.serialization)
//
//    // HTTP
//    implementation(libs.bundles.okhttp)
//
//    // Chucker
//    debugImplementation(libs.chucker.debug)
//    releaseImplementation(libs.chucker.release)
//
//    // Navigation Component
//    implementation(libs.bundles.navigation)
//
//    // Paging
//    implementation(libs.bundles.paging)
//
//    // Animation
//    implementation(libs.bundles.animation)
//
//    // Location Services
//    implementation(libs.play.services.location)
//
//    // RecyclerView
//    implementation(libs.androidx.swiperefreshlayout)
//
//    // Volley
//    implementation(libs.volley)
//
//    androidTestImplementation(libs.bundles.android.test)
//    debugImplementation(libs.bundles.debug)
//    testImplementation(libs.bundles.test)
//
//    //  Dagger
//    implementation(libs.bundles.dagger)
//    ksp(libs.dagger.compiler)
//
//    //  Hilt
//    implementation(libs.bundles.hilt)
//    ksp(libs.bundles.hilt.compiler)
//
//    // WorkManager
//    implementation(libs.work.manager)
//
//    // DataStore
//    implementation(libs.bundles.datastore.preferences)
//
//    // Protobuf
//    implementation(libs.bundles.protobuf.datastore)
//
//    // Security
//    implementation(libs.bundles.security)
//
//    implementation(libs.splashscreen)
//    implementation(libs.leakcanary)
//
//    // Pluto
//    debugImplementation(libs.bundles.debug.pluto)
//    releaseImplementation(libs.bundles.release.pluto)
//
//    implementation(libs.libphonenumber)
//    implementation(libs.rebugger)
}

/*
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

 */


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


