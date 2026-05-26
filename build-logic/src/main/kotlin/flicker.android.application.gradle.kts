import com.android.build.api.dsl.ApplicationExtension
import io.github.funnuphatguy.flicker.buildlogic.configureAndroid
import io.github.funnuphatguy.flicker.buildlogic.configureCompose
import io.github.funnuphatguy.flicker.buildlogic.configureKotlin
import io.github.funnuphatguy.flicker.buildlogic.flickerVersion

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.compose")
}

extensions.configure<ApplicationExtension> {
    configureAndroid(this)
    configureCompose(this)

    namespace = "io.github.funnyphatguy.flicker"

    defaultConfig {
        applicationId = "io.github.funnyphatguy.flicker"
        targetSdk = flickerVersion("targetSdk").toInt()
        versionCode = flickerVersion("appVersionCode").toInt()
        versionName = flickerVersion("appVersionName")
    }
}

configureKotlin()