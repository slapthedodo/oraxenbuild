import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.20"
    id("io.papermc.paperweight.userdev")
}

val serverVersion = "1.21.5-R0.1-SNAPSHOT"


dependencies {
    paperweight.paperDevBundle(serverVersion)
    compileOnly(project(":core"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

class NMSVersion(val nmsVersion: String, val serverVersion: String)
infix fun String.toNms(that: String): NMSVersion = NMSVersion(this, that)