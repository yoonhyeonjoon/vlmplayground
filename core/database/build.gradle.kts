
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("vlmplayground.android.library")
    id("vlmplayground.android.library.jacoco")
    id("vlmplayground.android.hilt")
    alias(libs.plugins.ksp)
}

android {
    defaultConfig {
        // The schemas directory contains a schema file for each version of the Room database.
        // This is required to enable Room auto migrations.
        // See https://developer.android.com/reference/kotlin/androidx/room/AutoMigration.
        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }

        testInstrumentationRunner = "com.vlmplayground.android.core.testing.VlmTestRunner"
    }
    namespace = "com.vlmplayground.core.database"
}

dependencies {
    implementation(project(":core:model"))

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)

    androidTestImplementation(project(":core:testing"))


}