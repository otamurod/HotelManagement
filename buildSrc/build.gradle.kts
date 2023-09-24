plugins {
    `kotlin-dsl`
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    val kotlinVersion = "1.9.10"
    val hiltVersion = "2.47"

    // Android Gradle Plugin
    implementation("com.android.tools.build:gradle:7.4.2")

    // Kotlin Gradle Plugin
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

    // Hilt Android Plugin
    implementation("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")

    // KSP Plugin
    implementation("com.google.devtools.ksp:symbol-processing-gradle-plugin:1.9.10-1.0.13")

    // R8
    implementation("com.android.tools:r8:8.1.56")
}

gradlePlugin {
    plugins {
        create("android-module") {
            id = "android-module"
            implementationClass = "buildSrc.plugins.AndroidModulePlugin"
        }
        create("kotlin-module") {
            id = "kotlin-module"
            implementationClass = "buildSrc.plugins.KotlinModulePlugin"
        }
    }
}