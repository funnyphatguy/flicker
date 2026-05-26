package io.github.funnuphatguy.flicker.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun Project.flickerVersion(name: String): String =
    libs.findVersion(name).get().requiredVersion

internal fun Project.configureKotlin() {
    extensions.configure<KotlinProjectExtension> {
        jvmToolchain(flickerVersion("jvmTarget").toInt())
    }
}

internal fun Project.configureAndroid(
    commonExtension: CommonExtension
) {
    commonExtension.apply {
        compileSdk = flickerVersion("compileSdk").toInt()
        defaultConfig.minSdk = flickerVersion("minSdk").toInt()

        compileOptions.sourceCompatibility = JavaVersion.VERSION_21
        compileOptions.targetCompatibility = JavaVersion.VERSION_21
    }
}


internal fun Project.configureCompose(
    commonExtension: CommonExtension
) {
    commonExtension.buildFeatures.compose = true
}
