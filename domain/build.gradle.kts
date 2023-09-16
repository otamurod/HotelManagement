import uz.otamurod.buildsrc.Lib

plugins {
    id("kotlin")
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    // Dagger - Hilt
    implementation(Lib.DaggerHilt.android)
    implementation(Lib.DaggerHilt.hiltNavigationFragment)

    // Testing
    testImplementation(Lib.Testing.junit)
}