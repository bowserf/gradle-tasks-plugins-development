buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    }
}

plugins {
    `kotlin-dsl`
    id("java-gradle-plugin")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation("org.json:json:20210307")
}

gradlePlugin {
    plugins {
        create("bundleReleaseFiles") {
            id = "fr.bowser.bundle_release_files"
            implementationClass =
                "BundleReleaseFilesPlugin"
        }
    }
}
