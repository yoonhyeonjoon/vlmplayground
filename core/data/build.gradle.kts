
plugins {
    id("vlmplayground.android.library")
    id("vlmplayground.android.library.jacoco")
    id("vlmplayground.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "com.vlmplayground.android.core.data"

    defaultConfig {
        testInstrumentationRunner = "com.vlmplayground.core.data.CustomTestRunner"
    }

}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":core:database"))
//    implementation(project(":core:datastore"))
    implementation(project(":core:network"))
    testImplementation(project(":core:testing"))
    testImplementation(project(":core:datastore-test"))

    implementation(libs.androidx.core.ktx)

    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)


    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.firestore)
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    androidTestImplementation("com.android.support.test:runner:1.0.2")
}