plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.compose)

}

android {
    compileSdk = 34
    namespace = "com.shmulik.data"


    defaultConfig {
        minSdk = 29
        consumerProguardFiles("proguard-rules.pro")
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            consumerProguardFiles("proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    api(project(":domain"))
    // Compose
    implementation(libs.bundles.compose)
    implementation(platform(libs.compose.bom))

    // Network
    implementation(libs.bundles.network)
    // Hilt
    implementation(libs.hilt.dagger.android)
    ksp(libs.hilt.dagger.compiler)
    ksp(libs.hilt.compiler)


}