
plugins {
    id("vlmplayground.android.library")
    id("vlmplayground.android.library.compose")
    id("vlmplayground.android.hilt")
}

android {
    namespace = "com.vlmplayground.android.core.testing"
}



dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    api(libs.junit4)
    api(libs.kotlinx.coroutines.test)
    api(libs.turbine)

    api(libs.androidx.test.core)
    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.runner)
    api(libs.androidx.test.rules)
    api(libs.androidx.compose.ui.test)
    api(libs.hilt.android.testing)

    api(platform(libs.firebase.bom))
    api(libs.firebase.firestore)

    debugApi(libs.androidx.compose.ui.testManifest)




}
