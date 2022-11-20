
plugins {
    id("vlmplayground.android.library")
    id("vlmplayground.android.library.compose")
    id("vlmplayground.android.hilt")
}

android {
    namespace = "com.vlmplayground.android.core.testing"

    testOptions {
        unitTests.isReturnDefaultValues = true
    }

    defaultConfig {
//        testInstrumentationRunner = "com.vlmplayground.core.testing.VlmTestRunner"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

}



dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    api(libs.junit4)
    api(libs.androidx.test.core)
    api(libs.kotlinx.coroutines.test)
    api(libs.turbine)

    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.runner)
    api(libs.androidx.test.rules)
    api(libs.androidx.compose.ui.test)
    api(libs.hilt.android.testing)

    debugApi(libs.androidx.compose.ui.testManifest)


}
