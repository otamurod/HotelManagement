import buildSrc.Dependencies

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin-module")
}

dependencies {
    // Kotlin Coroutines
    implementation(Dependencies.Coroutines.coroutinesCore)
    implementation(Dependencies.Coroutines.coroutinesAndroid)

    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.converterGson)
}