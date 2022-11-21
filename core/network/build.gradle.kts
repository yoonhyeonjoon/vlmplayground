/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    id("vlmplayground.android.library")
    id("vlmplayground.android.library.jacoco")
    id("vlmplayground.android.hilt")
    id("kotlinx-serialization")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")

    id("com.google.gms.google-services")
}

android {
    buildFeatures {
        buildConfig = true
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
    defaultConfig {
//        testInstrumentationRunner = "com.vlmplayground.core.testing.VlmTestRunner"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    namespace = "com.vlmplayground.core.network"
}

secrets {
    defaultPropertiesFileName = "secrets.defaults.properties"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))

    testImplementation(project(":core:testing"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)

    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.firestore)

    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test:rules:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")

    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.test:core:1.5.0")
    testImplementation("org.mockito:mockito-core:3.4.6")
    androidTestImplementation("org.mockito:mockito-android:2.24.5")


    androidTestImplementation(libs.androidx.work.testing)


}
