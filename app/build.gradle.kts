plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.serialization)
    alias(libs.plugins.compose)

    alias(libs.plugins.lsplugin.jgit)
    alias(libs.plugins.lsplugin.apksign)
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
    kotlin {
        jvmToolchain(rootProject.extra["jvmToolchain"] as Int)
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
}


dependencies {
    implementation(project(mapOf("path" to ":library:CircleToSearch")))

    implementation(libs.bundles.android)
    implementation(libs.bundles.compose)
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))

    //  ViewModel & LiveData
    implementation(libs.bundles.lifecycle)

    //  Room components
    implementation(libs.bundles.room)
    ksp(libs.androidx.room.compiler)

    // Serialization
    implementation(libs.bundles.serialization)

    // Navigation Component
    implementation(libs.bundles.navigation)

    androidTestImplementation(libs.bundles.android.test)
    debugImplementation(libs.bundles.debug)
    testImplementation(libs.bundles.test)

    // WorkManager
    implementation(libs.work.manager)
    implementation(libs.work.manager.multiprocess)

    // DataStore
    implementation(libs.bundles.datastore.preferences)

//    implementation(libs.splashscreen)
//    implementation(libs.leakcanary)
//
//    // Pluto
//    debugImplementation(libs.bundles.debug.pluto)
//    releaseImplementation(libs.bundles.release.pluto)


    val media3_version = "1.5.1"
    implementation("androidx.media3:media3-ui:$media3_version") // UI components for media playback
    implementation("androidx.media3:media3-exoplayer:$media3_version") // Core ExoPlayer
    implementation("androidx.media3:media3-exoplayer-dash:$media3_version") // DASH support
    implementation("androidx.media3:media3-exoplayer-hls:$media3_version") // HLS support
    implementation("androidx.media3:media3-exoplayer-smoothstreaming:$media3_version") // SmoothStreaming support
    implementation("androidx.media3:media3-exoplayer-rtsp:$media3_version") // RTSP support
    implementation("androidx.media3:media3-exoplayer-midi:$media3_version") // MIDI support
    implementation("androidx.media3:media3-exoplayer-ima:$media3_version") // Interactive Media Ads support

    implementation("androidx.media3:media3-session:$media3_version") // Media session management
    implementation("androidx.media3:media3-extractor:$media3_version") // Media extraction utilities

    implementation("androidx.media3:media3-datasource-cronet:$media3_version") // Cronet data source
    implementation("androidx.media3:media3-datasource-okhttp:$media3_version") // OkHttp data source
    implementation("androidx.media3:media3-datasource-rtmp:$media3_version") // RTMP data source

    implementation("androidx.media3:media3-cast:$media3_version") // Google Cast integration
    implementation("androidx.media3:media3-exoplayer-workmanager:$media3_version") // WorkManager integration
    implementation("androidx.media3:media3-transformer:$media3_version") // Media transformation utilities
    implementation("androidx.media3:media3-effect:$media3_version") // Video effects support
    implementation("androidx.media3:media3-muxer:$media3_version") // Media muxing utilities

    implementation("androidx.media3:media3-container:$media3_version") // Media container utilities
    implementation("androidx.media3:media3-database:$media3_version") // Media database support
    implementation("androidx.media3:media3-decoder:$media3_version") // Media decoding utilities
    implementation("androidx.media3:media3-datasource:$media3_version") // General data source utilities
    implementation("androidx.media3:media3-common:$media3_version") // Common media utilities
    implementation("androidx.media3:media3-common-ktx:$media3_version") // Kotlin extensions for common media utilities
    
    implementation("io.github.junkfood02.youtubedl-android:library:0.17.2") // https://github.com/JunkFood02/youtubedl-android
    implementation("io.github.junkfood02.youtubedl-android:ffmpeg:0.17.2")
    implementation("io.github.junkfood02.youtubedl-android:aria2c:0.17.2")
    implementation("androidx.webkit:webkit:1.12.1")
    implementation("org.jsoup:jsoup:1.19.1")
    implementation("com.github.marlonlom:timeago:4.1.0")
}

