plugins {
    `kotlin-dsl`
    id("java-gradle-plugin")
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("bundleReleaseFiles") {
            id = "fr.bowser.bundle_release_files"
            implementationClass = "BundleReleaseFilesPlugin"
        }
    }
}
