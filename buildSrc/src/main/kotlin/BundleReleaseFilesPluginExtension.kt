import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property

interface BundleReleaseFilesPluginExtension {
    val rootProject: DirectoryProperty
    val appVersion: Property<String>
    val outputDirectory: DirectoryProperty
}
