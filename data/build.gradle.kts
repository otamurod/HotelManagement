import uz.otamurod.buildsrc.Config
import uz.otamurod.buildsrc.Lib

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(Config.Sdk.compile)
    defaultConfig {
        namespace = Config.packageNameLibData
    }
}

dependencies {
    // AndroidX
    implementation(Lib.AndroidX.coreKtx)
    implementation(Lib.AndroidX.appCompat)
    implementation(Lib.AndroidX.material)

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

    // Picasso
    implementation(Lib.Picasso.picasso)
}
