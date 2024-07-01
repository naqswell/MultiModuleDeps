pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MultiModuleDeps"
include(":app")
include(":core")

include(":feature-main")
include(":feature-args-consumer")
include(":core-dagger")
include(":feature-sample-app")
include(":feature-sample-app:sample-app")
include(":feature-compound-view")
include(":feature-threads")
include(":feature-flowriddles")
