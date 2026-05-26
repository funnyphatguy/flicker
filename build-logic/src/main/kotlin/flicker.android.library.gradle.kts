import com.android.build.api.dsl.LibraryExtension
import io.github.funnuphatguy.flicker.buildlogic.configureAndroid
import io.github.funnuphatguy.flicker.buildlogic.configureKotlin


plugins {
    id("com.android.library")
}

extensions.configure<LibraryExtension> {
    configureAndroid(this)
    namespace = "io.github.funnuphatguy.flicker" + path.replace(":", ".")
}

configureKotlin()