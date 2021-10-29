package com.doing.gradle.router

import org.gradle.api.Plugin
import org.gradle.api.Project

class RouterPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println("I'm RouterPlugin Plugin, apply from ${project.name} ${RouterExtension}")

        project.getExtensions().add("router", RouterExtension)
        project.afterEvaluate {
            RouterExtension extension = project["router"]
            if (extension != null) {
                println("RouterPlugin extension path: ${extension.path}")
            }
        }
    }
}