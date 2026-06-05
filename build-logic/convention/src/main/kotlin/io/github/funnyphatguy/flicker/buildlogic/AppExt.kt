package io.github.funnyphatguy.flicker.buildlogic

import org.gradle.api.Project

internal val Project.derivedNamespace: String
    get() = "io.github.funnyphatguy.flicker" + path.replace(":", ".")