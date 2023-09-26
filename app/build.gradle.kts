import buildsrc.Config
import buildsrc.Dependencies

plugins {
    id("com.android.application")
    kotlin("android")
    id("android-module")
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    defaultConfig {
        applicationId = Config.applicationId
        namespace = Config.packageNameApp

        buildConfigField("String", "BASE_URL", "\"https://run.mocky.io\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    api(fileTree("libs") { include("*.jar") })

    // Inject Data Layer
    implementation(project(":data"))

    // Inject Domain Layer
    implementation(project(":domain"))

    // Inject Presentation Layer
     implementation(project(":presentation"))

    // AndroidX
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.appCompat)

    // Hilt Dependencies
    implementation(Dependencies.Hilt.hiltAndroid)
    implementation(Dependencies.Hilt.hiltNavigationFragment)
    ksp(Dependencies.Hilt.hiltCompiler)

    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.converterGson)

    // Okhttp3 Dependency
    implementation(Dependencies.Okhttp3.okhttp)
    implementation(Dependencies.Okhttp3.loggingInterceptor)
}