import buildsrc.Config
import buildsrc.Dependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("android-module")
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    defaultConfig {
        namespace = Config.packageNameLibData

        buildConfigField("String", "BASE_URL", "\"https://run.mocky.io\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    // Inject Domain Layer
    implementation(project(":domain"))

    // Kotlin Coroutines
    implementation(Dependencies.Coroutines.coroutinesCore)
    implementation(Dependencies.Coroutines.coroutinesAndroid)

    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.converterGson)

    // Hilt Dependencies
    implementation(Dependencies.Hilt.hiltAndroid)
    implementation(Dependencies.Hilt.hiltNavigationFragment)
    ksp(Dependencies.Hilt.hiltCompiler)

    // Okhttp3 Dependency
    implementation(Dependencies.Okhttp3.okhttp)
    implementation(Dependencies.Okhttp3.loggingInterceptor)
}