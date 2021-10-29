package com.doing.build

import org.gradle.api.Plugin
import org.gradle.api.Project

class BuildSrcPlugin implements Plugin<Project> {

    @Override
        void apply(Project project) {
            println("===============I'm BuildSrcPlugin=============")
        }
}