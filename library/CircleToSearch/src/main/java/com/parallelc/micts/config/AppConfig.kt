package com.parallelc.micts.config
import com.parallelc.micts.R
import java.util.Locale

enum class Language(val id: Int, val toLocale: () -> Locale) {
    FollowSystem(R.string.follow_system, { Locale.getDefault() }),
    English(R.string.english, { Locale.ENGLISH }),
    SimplifiedChinese(R.string.simplified_chinese, { Locale.SIMPLIFIED_CHINESE }),
    TraditionalChinese(R.string.traditional_chinese, { Locale.TRADITIONAL_CHINESE })
}

object AppConfig {
    const val CONFIG_NAME = "app_config"
    const val KEY_LANGUAGE = "language"
    const val KEY_DEFAULT_DELAY = "default_delay"
    const val KEY_TILE_DELAY = "tile_delay"
    const val KEY_VIBRATE = "vibrate"

    val DEFAULT_CONFIG = mapOf<String, Any>(
        KEY_LANGUAGE to Language.FollowSystem.ordinal,
        KEY_DEFAULT_DELAY to 0L,
        KEY_TILE_DELAY to 400L,
        KEY_VIBRATE to false,
    )

    const val DEBUG: Boolean = true
    const val APPLICATION_ID: String = "com.dinesh.circleToSearch"
    const val BUILD_TYPE: String = "debug"
    const val VERSION_CODE: Int = 1
    const val VERSION_NAME: String = "1.0"
}
