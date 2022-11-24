
plugins {
    id("vlmplayground.android.library")
    id("vlmplayground.android.library.jacoco")
    id("vlmplayground.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.vlmplayground.android.core.data"

    defaultConfig {
        testInstrumentationRunner = "com.vlmplayground.android.core.testing.VlmTestRunner"
    }

}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":core:database"))
//    implementation(project(":core:datastore"))
    implementation(project(":core:network"))


    implementation(libs.androidx.core.ktx)

    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)


    androidTestImplementation(project(":core:testing"))
    testImplementation(project(":core:testing"))
    testImplementation(project(":core:datastore-test"))

}