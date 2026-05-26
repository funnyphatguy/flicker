import com.android.build.api.dsl.LibraryExtension
import io.github.funnuphatguy.flicker.buildlogic.configureCompose

plugins {
    id("flicker.android.library")
    id("org.jetbrains.kotlin.plugin.compose")
}

extensions.configure<LibraryExtension> {
    configureCompose(this)
}