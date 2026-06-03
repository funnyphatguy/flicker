import com.android.build.api.dsl.ApplicationExtension
import io.github.funnyphatguy.flicker.buildlogic.configureAndroid
import io.github.funnyphatguy.flicker.buildlogic.configureCompose
import io.github.funnyphatguy.flicker.buildlogic.configureKotlin
import io.github.funnyphatguy.flicker.buildlogic.flickerVersion
import io.github.funnyphatguy.flicker.buildlogic.pluginId
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(pluginId("android-application"))
            apply(pluginId("compose-compiler"))
        }
        extensions.configure<ApplicationExtension> {
            configureAndroid(this)
            configureCompose(this)

            namespace = "io.github.funnyphatguy.flicker"

            defaultConfig {
                applicationId = "ioZ.github.funnyphatguy.flicker"
                targetSdk = flickerVersion("targetSdk").toInt()
                versionCode = flickerVersion("appVersionCode").toInt()
                versionName = flickerVersion("appVersionName")
            }
        }
        configureKotlin()
    }
}