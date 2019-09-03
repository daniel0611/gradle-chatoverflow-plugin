package com.github.daniel0611.chatoverflow

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.api.plugins.MavenPluginConvention
import java.io.File


class PomInclusionPlugin : Plugin<Project> {
    override fun apply(p: Project) {
        val pomFile = File("${p.buildDir}/chatoverflow/pom/dependencies.pom")

        // Pom task to generate a pom file
        p.pluginManager.apply("maven")

        val pom = p.task("pom").doLast {
            p.convention.findPlugin(MavenPluginConvention::class.java)
                ?.pom {
                    if (it.groupId.isBlank()) {
                        it.groupId = it.artifactId
                    }
                }
                ?.writeTo(pomFile)
        }


        // Include pom in jar
        p.pluginManager.apply("java")
        p.tasks.findByName("processResources")?.dependsOn(pom)

        p.convention.findPlugin(JavaPluginConvention::class.java)
            ?.sourceSets
            ?.findByName("main")
            ?.resources
            ?.srcDirs(pomFile.parent)
    }
}