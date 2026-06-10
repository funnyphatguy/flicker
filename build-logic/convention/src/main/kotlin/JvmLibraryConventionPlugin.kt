import io.github.funnyphatguy.flicker.buildlogic.configureKotlin
import io.github.funnyphatguy.flicker.buildlogic.pluginId
import org.gradle.api.Plugin
import org.gradle.api.Project

class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(pluginId("jetbrains-kotlin-jvm"))
        }
        configureKotlin()
    }
}