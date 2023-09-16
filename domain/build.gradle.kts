import uz.otamurod.buildsrc.Config
import uz.otamurod.buildsrc.Lib

plugins {
    id("com.android.library")
    id("kotlin-parcelize")
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

android {
    namespace = Config.packageNameLibDomain
    compileSdk = Config.Sdk.compile
}

dependencies {
    // Testing
    testImplementation(Lib.Testing.junit)

    // Kotlin Coroutines
    implementation(Lib.Coroutines.core)
    implementation(Lib.Coroutines.android)

    // Retrofit
    implementation(Lib.Retrofit.retrofit)
    implementation(Lib.Retrofit.converterGson)
    implementation(Lib.Retrofit.loggingInterceptor)
}