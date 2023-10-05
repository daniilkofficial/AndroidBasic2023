pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidBasic2023"
include(":app")
include(":la2calculator")
include(":la3messenger")
include(":la4gamescore")
include(":la5cafe")
include(":la6todolist")
include(":la8dogs")
include(":la9movies")
include(":la10firebasemessenger")
include(":la11btestbraintrainer")
