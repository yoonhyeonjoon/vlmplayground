
pluginManagement {
    includeBuild("build-logic")
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
rootProject.name = "vlmplayground"
include(":app")
include(":app-nia-catalog")
include(":benchmark")
include(":core:common")
include(":core:data")
//include(":core:data-test")
include(":core:database")
include(":core:datastore")
//include(":core:datastore-test")
include(":core:designsystem")
include(":core:domain")
include(":core:model")
include(":core:network")
include(":core:ui")
include(":core:testing")
include(":feature:bulletin")
include(":feature:rounge")
include(":feature:chatroom")
include(":feature:settings")
include(":lint")
include(":sync:work")
