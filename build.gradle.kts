plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.ksp) apply false
}

val compileSdk by extra(35)
val targetSdk by extra(35)
val minSdk by extra(28)
val javaVersion by extra(JavaVersion.VERSION_21)
val jvmToolchain by extra(21)

