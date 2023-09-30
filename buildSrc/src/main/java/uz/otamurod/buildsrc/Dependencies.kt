package buildsrc

object Dependencies {
    object AndroidX {
        const val appCompatVersion = "1.6.1"
        const val materialVersion = "1.9.0"
        const val constraintLayoutVersion = "2.1.4"
        const val legacySupportVersion = "1.0.0"
        const val coreKtxVersion = "1.12.0"
        const val fragmentKtxVersion = "1.6.1"

        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
        const val material = "com.google.android.material:material:$materialVersion"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
        const val legacySupport = "androidx.legacy:legacy-support-v13:$legacySupportVersion"
        const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:$fragmentKtxVersion"

        object Navigation {
            const val navigationVersion = "2.7.2"
            const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:$navigationVersion"
        }

        object Lifecycle {
            const val liveDataVersion = "2.2.0"
            const val viewModelVersion = "2.6.2"
            const val lifecycleLiveDataKtx =
                "androidx.lifecycle:lifecycle-extensions:$liveDataVersion"
            const val lifecycleViewModelKtx =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelVersion"
        }
    }

    object Hilt {
        private const val hiltVersion = "2.47"
        private const val hiltNavFragmentVersion = "1.0.0"
        const val hiltAndroid = "com.google.dagger:hilt-android:$hiltVersion"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
        const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:$hiltVersion"
        const val hiltAndroidGradlePlugin =
            "com.google.dagger:hilt-android-gradle-plugin:$hiltVersion"
        const val hiltNavigationFragment = "androidx.hilt:hilt-navigation-fragment:$hiltNavFragmentVersion"
    }

    object Coroutines {
        const val coroutinesAndroidVersion = "1.7.3"
        const val coroutinesCoreVersion = "1.7.3"
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesAndroidVersion"
        const val coroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesCoreVersion"
    }

    object Retrofit {
        private const val retrofitVersion = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    }

    object Okhttp3 {
        const val okHttpVersion = "5.0.0-alpha.11"
        const val okhttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
    }

    object ViewPager2 {
        private const val version = "1.0.0"
        const val viewPager2 = "androidx.viewpager2:viewpager2:$version"
    }

    object Glide {
        const val glideVersion = "4.16.0"
        const val glideCompiler = "com.github.bumptech.glide:ksp:$glideVersion" // replaced with ksp
        const val glide = "com.github.bumptech.glide:glide:$glideVersion"
    }

    object Picasso {
        private const val version = "2.8"
        const val picasso = "com.squareup.picasso:picasso:$version"
    }

    object CarouselView {
        private const val version = "0.1.6"
        const val carouselView = "com.synnapps:carouselview:$version"
    }

    object RoundedImageView {
        private const val version = "2.3.0"
        const val roundedImageView = "com.makeramen:roundedimageview:$version"
    }

    object Shimmer {
        private const val version = "0.5.0"
        const val shimmer = "com.facebook.shimmer:shimmer:$version"
    }
}