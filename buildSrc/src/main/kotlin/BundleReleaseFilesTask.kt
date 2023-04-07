import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

internal abstract class BundleReleaseFilesTask : DefaultTask() {

    @get:InputDirectory
    abstract val rootProject: DirectoryProperty

    @get:Input
    abstract val appVersion: Property<String>

    @get:OutputDirectory
    abstract val outputDirectory: DirectoryProperty

    @TaskAction
    fun run() {
        val rootProjectFile = rootProject.get().asFile
        check(rootProjectFile.exists())

        val buildOutputsDirectory = File(rootProjectFile, "build/outputs")
        if (!buildOutputsDirectory.exists()) {
            throw IllegalStateException("File doesn't exist: ${buildOutputsDirectory.absolutePath}")
        }

        val resultDirectory = File(outputDirectory.get().asFile, appVersion.get())
        if (resultDirectory.exists()) {
            if (!resultDirectory.deleteRecursively()) {
                throw IllegalStateException("Output directory deletion failed at path: ${resultDirectory.absolutePath}")
            }
        }
        if (!resultDirectory.mkdirs()) {
            throw IllegalStateException("Error when creating output directory at path: ${resultDirectory.absolutePath}")
        }

        val apkReleaseDirectory = File(buildOutputsDirectory, "apk/release")
        if (!apkReleaseDirectory.exists()) {
            throw java.lang.IllegalStateException("Release Apk directory doesn't exist at path ${apkReleaseDirectory.absolutePath}")
        }
        val apkReleaseFile = apkReleaseDirectory.listFiles().first { it.extension == "apk" }
        apkReleaseFile.copyTo(File(resultDirectory, apkReleaseFile.name))

        val bundleReleaseDirectory = File(buildOutputsDirectory, "bundle/release")
        if (!bundleReleaseDirectory.exists()) {
            throw java.lang.IllegalStateException("Release Bundle directory doesn't exist at path: ${bundleReleaseDirectory.absolutePath}")
        }
        val bundleReleaseFile = bundleReleaseDirectory.listFiles().first { it.extension == "aab" }
        bundleReleaseFile.copyTo(File(resultDirectory, bundleReleaseFile.name))

        val mappingReleaseFile = File(buildOutputsDirectory, "mapping/release/mapping.txt")
        mappingReleaseFile.copyTo(File(resultDirectory, mappingReleaseFile.name))
    }
}
