plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.parallelc.micts"
    compileSdk = rootProject.extra["compileSdk"] as Int

    defaultConfig {
        minSdk = rootProject.extra["minSdk"] as Int

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    compileOnly(project(":library:libxposed"))
    compileOnly(project(":library:libxposed:libxposed-compat"))
    compileOnly(project(":library:libxposed:api"))    //  https://github.com/libxposed/api.git
    compileOnly(project(":library:libxposed:api:checks")) //  https://github.com/libxposed/api.git

    compileOnly(project(":library:libxposed:service"))    //  https://github.com/libxposed/service.git
    implementation(project(":library:libxposed:service:interface"))   //  https://github.com/libxposed/service.git

    //  Xposed AP
    compileOnly("de.robv.android.xposed:api:82")
    compileOnly("de.robv.android.xposed:api:82:sources")

    implementation(libs.hiddenapibypass)

    implementation(libs.bundles.android)
    implementation(libs.bundles.compose)
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))
    implementation(libs.accompanist.drawablepainter)
//    implementation(libs.androidx.compose.animation.core.android)
//    implementation(libs.androidx.compose.animation.android)
}