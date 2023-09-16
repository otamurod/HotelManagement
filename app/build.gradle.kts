import uz.otamurod.buildsrc.Config
import uz.otamurod.buildsrc.Lib

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

android {
    namespace = Config.packageNameApp
    compileSdk = 34

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.Sdk.min
        targetSdk = Config.Sdk.target
        versionCode = Config.Build.versionCode
        versionName = Config.Build.versionName
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    api(fileTree("libs") { include("*.jar") })

    // Inject Data Layer
    implementation(project(mapOf("path" to ":data")))

    // Inject Domain Layer
    implementation(project(mapOf("path" to ":domain")))

    // Inject Presentation Layer
    implementation(project(mapOf("path" to ":presentation")))

    // AndroidX
    implementation(Lib.AndroidX.coreKtx)
    implementation(Lib.AndroidX.appCompat)
    implementation(Lib.AndroidX.material)
    implementation(Lib.AndroidX.constraintLayout)
    implementation(Lib.AndroidX.legacySupport)
    implementation(Lib.AndroidX.lifecycleLiveDataKtx)
    implementation(Lib.AndroidX.lifecycleViewModelKtx)

    // Testing
    testImplementation(Lib.Testing.junit)
    androidTestImplementation(Lib.Testing.junitExt)
    androidTestImplementation(Lib.Testing.espressoCore)

    // Navigation
    implementation(Lib.Navigation.fragment)
    implementation(Lib.Navigation.ui)

    // LiveData
    implementation(Lib.LiveData.lifecycle)

    // ViewModel
    implementation(Lib.ViewModel.lifecycleViewModel)
    implementation(Lib.ViewModel.lifecycleExtensions)
    implementation(Lib.ViewModel.lifecycleRuntime)
    implementation(Lib.ViewModel.activityKtx)

    // Dagger - Hilt
    implementation(Lib.DaggerHilt.android)
    implementation(Lib.DaggerHilt.hiltNavigationFragment)
    kapt(Lib.DaggerHilt.hiltAndroidCompiler)
    kapt(Lib.DaggerHilt.hiltCompiler)

    // Kotlin Coroutines
    implementation(Lib.Coroutines.core)
    implementation(Lib.Coroutines.android)

    // Retrofit
    implementation(Lib.Retrofit.retrofit)
    implementation(Lib.Retrofit.converterGson)
    implementation(Lib.Retrofit.loggingInterceptor)

    // ViewPager 2
    implementation(Lib.ViewPager2.viewPager2)

    // Glide
    implementation(Lib.Glide.glide)
    kapt(Lib.Glide.glideCompiler)

    // Picasso
    implementation(Lib.Picasso.picasso)

    // CarouselView
    implementation(Lib.CarouselView.carouselView)

    // Shimmer effect
    implementation(Lib.Shimmer.shimmer)
}