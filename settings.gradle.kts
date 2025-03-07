import java.net.URI

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
//        id("com.android.application") version "8.7.2"
//        id("org.jetbrains.kotlin.android") version "2.0.0"
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://api.xposed.info/")
        }
        mavenLocal {
            content {
                includeGroup("io.github.libxposed")
            }
        }
        maven { url = uri("https://github.com/libxposed/api.git") } // Add this line
        maven { url = uri("https://github.com/libxposed/service.git") } // Add this line
    }


    versionCatalogs {
        create("libs") {
            library("libxposed-api", "io.github.libxposed", "api").version {
                branch = "master"
            }
            library("libxposed-service", "io.github.libxposed", "service").version {
                branch = "master"
            }
        }
    }


}

sourceControl {
    gitRepository(URI.create("https://github.com/libxposed/api.git")) {
        producesModule("io.github.libxposed:api")
    }
    gitRepository(URI.create("https://github.com/libxposed/service.git")) {
        producesModule("io.github.libxposed:service")
    }
}

rootProject.name = "Dinesh28"
include(":app", ":api", ":checks", ":service", ":interface")

include(":library:libxposed")
include(":library:libxposed:api")
include(":library:libxposed:api:checks")
include(":library:libxposed:service")
include(":library:libxposed:service:interface")
include(":library:libxposed:libxposed-compat")

include(":library:lib1")