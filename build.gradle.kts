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
    mpsPlugins(files("/home/amir/Downloads/zargari-0.0.1-20201117.194733-5 (2).zip"))
}

val mpsLocation = File(buildDir, "mps")
val pluginsDir = File(mpsLocation, "plugins")

val genExt = extensions.getByType<de.itemis.mps.gradle.generate.GeneratePluginExtensions>().apply {
    projectLocation = projectDir
    mpsConfig = mps
    pluginLocation = pluginsDir
    plugins = mpsPlugins.dependencies.asSequence()
        .flatMap { mpsPlugins.files(it).asSequence() }
        .map { toPlugin(it) }
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
