plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.flixster"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.flixster"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation (libs.glide)
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
    implementation ("com.codepath.libraries:asynchttpclient:2.2.0")
    implementation ("com.google.code.gson:gson:2.8.5")
    implementation (libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)
    implementation (libs.androidx.core.ktx.v170)
    implementation (libs.androidx.appcompat.v151)
    implementation (libs.material.v161)
    implementation (libs.androidx.constraintlayout.v220)
    testImplementation (libs.junit)
    androidTestImplementation (libs.androidx.junit.v113)
    androidTestImplementation (libs.androidx.espresso.core.v340)
}