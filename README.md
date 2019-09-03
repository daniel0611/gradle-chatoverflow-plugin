# gradle-chatoverflow-plugin

A plugin to enable development of [ChatOverflow](https://github.com/codeoverflow-org/chatoverflow) plugins with Gradle.

It was created to be able to create plugins written in [Kotlin](https://kotlinlang.org), because there isn't a sbt 1.x compatible Kotlin compiler plugin yet. The master branch of [pfn/kotlin-plugin](https://github.com/pfn/kotlin-plugin) has support, but isn't yet available as a release. Also I wanted to learn a bit about Gradle.

**Only compatible with ChatOverflow prealpha 3 and newer!**

Current status: ***WIP, theoretically usable*** 

## Features

* #### Export pom to the jar

  Status: implemented and working
  
  Does the same thing that the [`PomIncluisionPlugin`](https://github.com/codeoverflow-org/chatoverflow/blob/eaef935387c032eb0d2d226e73f2671cb08655c6/build/src/main/scala/org/codeoverflow/chatoverflow/build/PomInclusionPlugin.scala) of the official sbt build code does. It includes a pom with all dependencies of the plugin in the packaged jar. At runtime the framework then downloads and ensures that these dependencies are available to the plugin. Useful for e.g. the Kotlin Library or any other dependency that is available on Maven Central.

* #### Test plugin on a local bootstrap installation

  Status: ***WIP, depends on official prealpha 3 release***

  A `run` Gradle task will download and setup an installation of the specified ChatOverflow version. It builds the jar of the plugin and finally starts the ChatOverflow installation with the plugin copied into the plugin directory. This allows for quick iterative testing of your plugins without the need to copy the jar to an installation every time you make a change. 

  If you use sbt with an plugin development environment (they get released with prealpha 3 and up) or with the framework and api as source you obviously don't have this problem, because the sbt `copy` task will copy your plugins and you run the framework from a jar. This feature brings the developer experience on a similar level.

  

Feel free to request more features that you think might be useful by opening a GitHub issue!