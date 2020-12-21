
group "ir.amv.snippets"
version "1.0-SNAPSHOT"

buildscript {
    repositories {
        maven(url="https://projects.itemis.de/nexus/content/repositories/mbeddr")
        mavenCentral()
    }
    dependencies {
        classpath("generate-models:generate-models.gradle.plugin:1.2+")
    }
}

repositories {
    maven (url="http://localhost:8081/repository/maven-snapshots/")
    maven (url="https://projects.itemis.de/nexus/content/repositories/mbeddr")
    jcenter()
}

apply(plugin="generate-models")

val mps = configurations.create("mps")

val mpsLocation = File(buildDir, "mps")

val mpsVersion = "2020.1.6"

val genExt = extensions.getByType<de.itemis.mps.gradle.generate.GeneratePluginExtensions>().apply {
    projectLocation = projectDir
    mpsConfig = mps
}
//    mpsPluginConfig = configurations.mpsPlugin

//tasks.named<JavaExec>("generate") {
//}

dependencies {
    "mps"("com.jetbrains:mps:$mpsVersion")
//    mpsPlugin "ir.amv.laas.samples:zargari:0.0.1-SNAPSHOT"
}
