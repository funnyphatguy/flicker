package io.github.funnyphatguy.flicker.buildlogic

import org.gradle.api.Project

internal fun derivedNamespace(project: Project): String {
    return "io.github.funnyphatguy.flicker" + project.path.replace(":", ".")
}