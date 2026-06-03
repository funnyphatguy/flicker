package io.github.funnyphatguy.flicker.buildlogic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

internal fun Project.configureCompose(
    commonExtension: CommonExtension
) {
    commonExtension.buildFeatures.compose = true
}