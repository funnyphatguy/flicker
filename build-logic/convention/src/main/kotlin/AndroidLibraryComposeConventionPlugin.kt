import com.android.build.api.dsl.LibraryExtension
import io.github.funnyphatguy.flicker.buildlogic.configureAndroid
import io.github.funnyphatguy.flicker.buildlogic.configureCompose
import io.github.funnyphatguy.flicker.buildlogic.configureKotlin
import io.github.funnyphatguy.flicker.buildlogic.derivedNamespace
import io.github.funnyphatguy.flicker.buildlogic.pluginId
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(pluginId("android-library"))
            apply(pluginId("compose-compiler"))
        }
        extensions.configure<LibraryExtension> {
            configureAndroid(this)
            configureCompose(this)
            namespace = target.derivedNamespace()
        }
        configureKotlin()
    }
}