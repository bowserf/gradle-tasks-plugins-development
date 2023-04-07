[![Gradle](https://img.shields.io/badge/Gradle-7.5-yellowgreen)]()
[![Android Gradle Plugin](https://img.shields.io/badge/Android%20Gradle%20Plugin-7.4.1-brightgreen)]()

# Learn how to create your own Gradle Tasks and Plugins

Companion sample project of the Medium article [Make Gradle work for you](https://medium.com/@bowser-f/make-gradle-do-more-work-for-you-than-just-build-your-android-app-9462baa08951).

This project showcases how is developed a Plugin that registers a simple Task.

The Task developed in this sample does a basic work. It copies in a directory:
- the release APK
- the release Bundle
- the mapping file

It must be applied to an Android app module.

To do that, the Task needs 3 parameters:
- A File pointing to the module the Task is used
- The Android app version to name the output directory from it
- A File pointing where the generated directory will be put.

To test the Task:
- Generate the 3 input files by executing: `./gradlew assembleRelease bundleRelease`
- Execute `./gradlew bundleReleaseFiles`
You should see a new directory at the path `app/build/outputs/1.00.00`