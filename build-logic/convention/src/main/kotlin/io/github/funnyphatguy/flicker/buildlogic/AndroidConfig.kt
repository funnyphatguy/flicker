package io.github.funnyphatguy.flicker.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

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