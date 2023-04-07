plugins {
    id("com.android.application")
    kotlin("android")
    id("fr.bowser.bundle_release_files")
}

android {
    namespace = "fr.bowser.bundle_release_files.sample"
    compileSdk = 33

    defaultConfig {
        applicationId = "fr.bowser.bundle_release_files.sample"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}

bundleReleaseFiles {
    appVersion.set("1.00.00")
    outputDirectory.set(File(".", "build/outputs"))
}
