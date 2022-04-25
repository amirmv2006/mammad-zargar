group "ir.amv.snippets"
version "1.0-SNAPSHOT"

repositories {
//    maven (url="http://localhost:8081/repository/maven-snapshots/")
    maven(url = "https://projects.itemis.de/nexus/content/repositories/mbeddr")
    jcenter()
}

plugins {
    id("generate-models")
}

val mpsVersion = "2020.1.6"
val mps = configurations.create("mps")
val mpsPlugins = configurations.create("mpsPlugins")

dependencies {
    mps("com.jetbrains:mps:$mpsVersion")
    // dependencies are resolved by the model generator app
    mpsPlugins(files("$projectDir/zargari.zip"))
}

val mpsLocation = File(buildDir, "mps")
val pluginsDir = File(mpsLocation, "plugins")

val genExt = extensions.getByType<de.itemis.mps.gradle.generate.GeneratePluginExtensions>().apply {
    projectLocation = projectDir
    mpsConfig = mps
    pluginLocation = pluginsDir
    plugins = mpsPlugins.dependencies.asSequence()
        .onEach { logger.lifecycle("My Dear Dependency: {}", it) }
        .flatMap { mpsPlugins.files(it).asSequence() }
        .map { toPlugin(it) }
        .onEach { logger.lifecycle("My Dear Plugin: {}", it) }
        .toList()
}

val copyMpsPluginsTask = tasks.register<Copy>("copyMpsPluginsTask") {
    dependsOn(tasks.named("fakeBuildNumber"))
    into(genExt.pluginLocation!!)
    mpsPlugins.asFileTree.forEach {
        from(zipTree(it))
    }
}

afterEvaluate {
    tasks.named("generate") {
        dependsOn(copyMpsPluginsTask)
    }
}
