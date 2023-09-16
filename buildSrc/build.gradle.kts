plugins {
    `kotlin-dsl`
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    // Android Gradle Plugin
    implementation("com.android.tools.build:gradle:7.4.2")
    // Kotlin Gradle Plugin
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    // Dagger Hilt Plugin
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.47")
}