package com.github.daniel0611.chatoverflow

import org.gradle.api.Plugin
import org.gradle.api.Project

class ChatOverflowPlugin : Plugin<Project> {
    override fun apply(p: Project) {
        p.pluginManager.apply(PomInclusionPlugin::class.java)
    }
}