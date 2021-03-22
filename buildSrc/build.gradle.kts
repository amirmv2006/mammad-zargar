import de.undercouch.gradle.tasks.download.Download

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    maven(url = "https://projects.itemis.de/nexus/content/repositories/mbeddr")
    jcenter()
}

dependencies {
    implementation("generate-models:generate-models.gradle.plugin:1.4+")
}
