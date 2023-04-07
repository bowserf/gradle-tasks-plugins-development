[![Gradle](https://img.shields.io/badge/Gradle-7.5-yellowgreen)]()
[![Android Gradle Plugin](https://img.shields.io/badge/Android%20Gradle%20Plugin-7.4.1-brightgreen)]()

# Learn how to create your own Gradle Tasks and Plugins

Companion sample project of the Medium article [Learn how to create your own Gradle Tasks and Plugins](https://medium.com/@bowser-f/make-gradle-do-more-work-for-you-than-just-build-your-android-app-9462baa08951).

## Objective

This project showcases how to develop a Plugin that registers a simple Task.

The Task developed in this sample does a basic work. It copies in a new directory:
- the release APK
- the release Bundle
- the mapping file

It must be applied to an Android app module.

To do that, the Task needs 2 parameters:
- The Android app version to name the output directory from it.
- A File pointing where the generated directory will be put.

## Test the Task

1. Generate the 3 input files by executing: `./gradlew assembleRelease bundleRelease`
2. Execute `./gradlew bundleReleaseFiles`
3. Check that a new directory has been generated at path `app/build/outputs/1.00.00`