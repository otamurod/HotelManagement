package uz.otamurod.buildsrc

object Lib {
    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val appCompat = "androidx.appcompat:appcompat:1.6.1"
        const val material = "com.google.android.material:material:1.9.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0"
        const val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.6.2"
        const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2"
    }

    object Testing {
        const val junit = "junit:junit:4.13.2"
        const val junitExt = "androidx.test.ext:junit:1.1.5"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.5.1"
    }

    object Navigation {
        private const val version = "2.6.0"
        const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val ui = "androidx.navigation:navigation-ui-ktx:$version"
    }

    object LiveData {
        private const val version = "2.4.0"
        const val lifecycle = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
    }

    object ViewModel {
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1"
        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"
        const val activityKtx = "androidx.activity:activity-ktx:1.7.2"
    }

    object DaggerHilt {
        private const val version = "2.47"
        const val android = "com.google.dagger:hilt-android:$version"
        const val hiltNavigationFragment = "androidx.hilt:hilt-navigation-fragment:1.0.0"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$version"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0"
    }

    object Coroutines {
        private const val version = "1.7.3"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.11"
    }

    object ViewPager2 {
        private const val version = "1.1.0-alpha01"
        const val viewPager2 = "androidx.viewpager2:viewpager2:$version"
    }

    object Glide {
        private const val version = "4.14.1"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val glideCompiler = "com.github.bumptech.glide:compiler:$version"
    }

    object Picasso {
        private const val version = "2.71828"
        const val picasso = "com.squareup.picasso:picasso:$version"
    }

    object CarouselView {
        private const val version = "0.1.4"
        const val carouselView = "com.synnapps:carouselview:$version"
    }

    object Shimmer {
        private const val version = "0.5.0"
        const val shimmer = "com.facebook.shimmer:shimmer:$version"
    }
}