import buildSrc.Config
import buildSrc.Dependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("android-module")
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
}

android {
    defaultConfig {
        namespace = Config.packageNameLibPresentation

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    api(fileTree("libs") { include("*.jar") })

    // Inject Domain Layer
    implementation(project(":domain"))

    // AndroidX
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.material)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.legacySupport)
    implementation(Dependencies.AndroidX.Lifecycle.lifecycleLiveDataKtx)
    implementation(Dependencies.AndroidX.Lifecycle.lifecycleViewModelKtx)

    // Navigation
    implementation(Dependencies.AndroidX.Navigation.fragmentKtx)
    implementation(Dependencies.AndroidX.Navigation.uiKtx)

    // LiveData
    implementation(Dependencies.AndroidX.Lifecycle.lifecycleLiveDataKtx)

    // ViewModel
    implementation(Dependencies.AndroidX.Lifecycle.lifecycleViewModelKtx)

    // Hilt Dependencies
    implementation(Dependencies.Hilt.hiltAndroid)
    implementation(Dependencies.Hilt.hiltNavigationFragment)
    ksp(Dependencies.Hilt.hiltCompiler)

    // Kotlin Coroutines
    implementation(Dependencies.Coroutines.coroutinesCore)
    implementation(Dependencies.Coroutines.coroutinesAndroid)

    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.converterGson)

    // Okhttp3 Dependency
    implementation(Dependencies.Okhttp3.okhttp)
    implementation(Dependencies.Okhttp3.loggingInterceptor)

    // ViewPager 2
    implementation(Dependencies.ViewPager2.viewPager2)

    // Glide
    implementation(Dependencies.Glide.glide)
    ksp(Dependencies.Glide.glideCompiler)

    // Picasso
    implementation(Dependencies.Picasso.picasso)

    // CarouselView
    implementation(Dependencies.CarouselView.carouselView)

    implementation(Dependencies.RoundedImageView.roundedImageView)

    // Shimmer effect
    implementation(Dependencies.Shimmer.shimmer)
}