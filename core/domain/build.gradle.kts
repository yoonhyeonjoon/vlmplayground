plugins{
    id("vlmplayground.android.library")
    id("vlmplayground.android.library.jacoco")
    id("vlmplayground.android.hilt")
}


dependencies{

    implementation(project(":core:data"))
    implementation(project(":core:database"))
    implementation(project(":core:model"))
    implementation(project(":core:common"))
    implementation(project(":core:network"))
}