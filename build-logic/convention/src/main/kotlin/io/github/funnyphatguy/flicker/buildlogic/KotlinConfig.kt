package io.github.funnyphatguy.flicker.buildlogic

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

internal fun Project.configureKotlin() {
    extensions.configure<KotlinProjectExtension> {
        jvmToolchain(flickerVersion("jvmTarget").toInt())
    }

    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}