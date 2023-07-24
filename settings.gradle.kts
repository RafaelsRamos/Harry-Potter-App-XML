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

rootProject.name = "HarryPotterWiki"
include(":app")
include(":data")
include(":network")
include(":database")
include(":domainmodel")
include(":feature:characterlisting")
include(":navigation")
include(":feature:characterdetails")
include(":ui")
