plugins {
    id("org.jetbrains.kotlin.jvm") version ("1.4.32")
    id("generate-models")
    id("com.google.cloud.artifactregistry.gradle-plugin") version ("2.1.1")
}

group = "ir.amv.snippets"
version = "1.0-SNAPSHOT"

repositories {
//    maven (url="http://localhost:8081/repository/maven-snapshots/")
    maven(url = "https://projects.itemis.de/nexus/content/repositories/mbeddr")
    maven(url = "artifactregistry://europe-west1-maven.pkg.dev/loco-repo-298115/loco-repo-langs")
    jcenter()
}

val mpsVersion = "2020.1.6"
val mps = configurations.create("mps")

dependencies {
    compile("amirmv2006:Zargari:v1.1")
    mps("com.jetbrains:mps:$mpsVersion")
}

val mpsLocation = File(buildDir, "mps")
val pluginsDir = File(mpsLocation, "plugins")

val genExt = extensions.getByType<de.itemis.mps.gradle.generate.GeneratePluginExtensions>().apply {
    projectLocation = projectDir
    mpsConfig = mps
    pluginLocation = pluginsDir
    plugins = configurations.runtime.dependencies.asSequence()
    .onEach { logger.lifecycle("My Dear Dependency: {}", it) }
        .flatMap { configurations.runtime.files(it).asSequence() }
    .map { toPlugin(it) }
        .onEach { logger.lifecycle("My Dear Plugin: {}", it) }
    .toList()
}

val copyMpsPluginsTask = tasks.register<Copy>("copyMpsPluginsTask") {
    dependsOn(tasks.named("fakeBuildNumber"))
    into(genExt.pluginLocation!!)
    configurations.runtime.asFileTree.forEach {
        from(zipTree(it))
    }
}

afterEvaluate {
    tasks.named("generate") {
        dependsOn(copyMpsPluginsTask)
    }
}
