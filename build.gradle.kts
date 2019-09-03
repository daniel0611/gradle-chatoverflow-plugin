import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-gradle-plugin`
    kotlin("jvm") version "1.3.41"
    id("com.gradle.plugin-publish") version "0.10.1"
}

group = "com.github.daniel0611"
version = "0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

pluginBundle {
    website = "https://github.com/daniel0611/gradle-chatoverflow-plugin"
    vcsUrl = "https://github.com/daniel0611/gradle-chatoverflow-plugin.git"
}

gradlePlugin {
    plugins {
        create("chatoverflowPlugin") {
            id = "com.github.daniel0611.chatoverflow"
            displayName = "ChatOverflow Plugin"
            description = "A plugin to enable development of ChatOverflow plugins with Gradle"
            implementationClass = "com.github.daniel0611.chatoverflow.ChatOverflowPlugin"
        }
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

