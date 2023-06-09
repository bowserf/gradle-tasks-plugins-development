import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File

class BundleReleaseFilesPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        val extension = target.extensions.create(
            "bundleReleaseFiles",
            BundleReleaseFilesPluginExtension::class.java
        )
        val bundleReleaseFilesTask = target.tasks.register(
            "bundleReleaseFiles",
            BundleReleaseFilesTask::class.java
        ) {
            this.group = "my_plugin"
            this.description =
                "Bundle release files (APK, Bundle and mapping) in the same directory"
        }
        bundleReleaseFilesTask.configure {
            appVersion.set(extension.appVersion)
            rootProject.set(target.projectDir)
            outputDirectory.set(extension.outputDirectory)
        }
    }
}
