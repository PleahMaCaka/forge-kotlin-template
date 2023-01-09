import org.spongepowered.asm.gradle.plugins.MixinExtension
import org.spongepowered.asm.gradle.plugins.struct.DynamicProperties
import java.text.SimpleDateFormat
import java.util.*

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
        classpath("org.spongepowered:mixingradle:0.7.+")
    }
}

apply(plugin = "kotlin")
apply(plugin = "org.spongepowered.mixin")

plugins {
    eclipse
    `maven-publish`
    id("net.minecraftforge.gradle") version "5.1.+"
    id("org.parchmentmc.librarian.forgegradle") version "1.+"
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.20"
}

version = "1.19-0.0.1.0"
group = "com.pleahmacaka"

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

println(
    "Java: " + System.getProperty("java.version") + " JVM: " + System.getProperty("java.vm.version") + "(" + System.getProperty(
        "java.vendor"
    ) + ") Arch: " + System.getProperty("os.arch")
)

minecraft {
    mappings("official", "1.19.3")
    mappings("parchment", "BLEEDING-SNAPSHOT-1.19.3")
    accessTransformer(file("src/main/resources/META-INF/accesstransformer.cfg"))

    runs.run {
        create("client") {
            workingDirectory(project.file("run"))
            property("forge.logging.markers", "REGISTRIES")
            property("forge.logging.console.level", "debug")
            property("forge.enabledGameTestNamespaces", "examplemod")
            property("terminal.jline", "true")
            property("log4j.configurationFile", "log4j2.xml") // pretty logger

            jvmArg("-XX:+AllowEnhancedClassRedefinition") // hotswap with JBRSDK
            // https://forge.gemwire.uk/wiki/Hotswap

            mods {
                create("examplemod") {
                    source(sourceSets.main.get())
                }
            }

            args(
                "--username", "Player",
            )
        }

        create("server") {
            workingDirectory(project.file("run"))
            property("forge.logging.markers", "REGISTRIES")
            property("forge.logging.console.level", "debug")
            property("forge.enabledGameTestNamespaces", "examplemod")
            property("terminal.jline", "true")

            mods {
                create("examplemod") {
                    source(sourceSets.main.get())
                }
            }
        }

        create("gameTestServer") {
            workingDirectory(project.file("run"))
            property("forge.logging.markers", "REGISTRIES")
            property("forge.logging.console.level", "debug")
            property("forge.enabledGameTestNamespaces", "examplemod")
            property("terminal.jline", "true")

            mods {
                create("examplemod") {
                    source(sourceSets.main.get())
                }
            }
        }

        create("data") {
            workingDirectory(project.file("run"))
            property("forge.logging.markers", "REGISTRIES")
            property("forge.logging.console.level", "debug")
            property("terminal.jline", "true")

            args(
                "--mod",
                "examplemod",
                "--all",
                "--output",
                file("src/generated/resources/"),
                "--existing",
                file("src/main/resources")
            )
            mods {
                create("examplemod") {
                    source(sourceSets.main.get())
                }
            }
        }
    }
}

configurations {
    minecraftLibrary {
        exclude("org.jetbrains", "annotations")
    }
}

val Project.mixin: MixinExtension
    get() = extensions.getByType()

mixin.run {
    add(sourceSets.main.get(), "examplemod.mixins.refmap.json")
    config("examplemod.mixins.json")
    val debug = this.debug as DynamicProperties
    debug.setProperty("verbose", true)
    debug.setProperty("export", true)
    setDebug(debug)
}

configurations {
    minecraftLibrary {
        exclude("org.jetbrains", "annotations")
    }
}

repositories {
    mavenCentral()
    maven {
        name = "Kotlin for Forge"
        url = uri("https://thedarkcolour.github.io/KotlinForForge/")
    }
}

dependencies {
    minecraft("net.minecraftforge:forge:1.19.3-44.1.0")
    annotationProcessor("org.spongepowered:mixin:0.8.5:processor")

    implementation("thedarkcolour:kotlinforforge:3.9.0") // waiting for 4.x.x
}

sourceSets.main.configure {
    resources.srcDirs("src/generated/resources/")
}

tasks.withType<Jar> {
    archiveBaseName.set("examplemod")
    manifest {
        val map = HashMap<String, String>()
        map["Specification-Title"] = "examplemod"
        map["Specification-Vendor"] = "pleahmacaka"
        map["Specification-Version"] = "1"
        map["Implementation-Title"] = project.name
        map["Implementation-Version"] = archiveBaseName.get()
        map["Implementation-Vendor"] = "pleahmacaka"
        map["Implementation-Timestamp"] = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(Date())
        attributes(map)
    }
    finalizedBy("reobfJar")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}