
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
//    id("kotlin")
//    id("vlmplayground.firebase")
    id("vlmplayground.android.library")
//    id("vlmplayground.android.library.jacoco")
//    id("vlmplayground.android.hilt")
//    id("kotlinx-serialization")
//    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

dependencies {
    implementation(libs.kotlinx.datetime)


    implementation(libs.firebase.firestore)
    implementation(platform(libs.firebase.bom))

}