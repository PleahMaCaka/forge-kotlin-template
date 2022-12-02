import net.minecraftforge.gradle.common.util.MinecraftExtension
import org.spongepowered.asm.gradle.plugins.MixinExtension
import org.spongepowered.asm.gradle.plugins.struct.DynamicProperties
import java.text.SimpleDateFormat
import java.util.*

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.21")
        classpath("org.spongepowered:mixingradle:0.7.+")
    }
}

apply(plugin = "kotlin")
apply(plugin = "org.spongepowered.mixin")
apply(from = "https://raw.githubusercontent.com/thedarkcolour/KotlinForForge/site/thedarkcolour/kotlinforforge/gradle/kff-3.7.1.gradle")

plugins {
    eclipse
    `maven-publish`

    id("net.minecraftforge.gradle") version "5.1.+"
    id("org.parchmentmc.librarian.forgegradle") version "1.+"
}

version = "1.19-0.0.5.0"
group = "com.pleahmacaka"

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

println(
    "Java: " + System.getProperty("java.version") + " JVM: " + System.getProperty("java.vm.version") + "(" + System.getProperty(
        "java.vendor"
    ) + ") Arch: " + System.getProperty("os.arch")
)

val Project.minecraft: MinecraftExtension
    get() = extensions.getByType()

val Project.mixin: MixinExtension
    get() = extensions.getByType()

minecraft.run {
    mappings("parchment", "2022.11.27-1.19.2")
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
    val library = maybeCreate("library")
    implementation.configure {
        extendsFrom(library)
    }
}

minecraft.runs.all {
    lazyToken("minecraft_classpath") {
        val joined = configurations.getByName("library").copyRecursive().resolve()
            .joinToString(File.pathSeparator) { it.absolutePath }
        println(joined)
        return@lazyToken joined
    }
}

mixin.run {
    add(sourceSets.main.get(), "examplemod.mixins.refmap.json")
    config("examplemod.mixins.json")
    val debug = this.debug as DynamicProperties
    debug.setProperty("verbose", true)
    debug.setProperty("export", true)
    setDebug(debug)
}

repositories {
    mavenCentral()
}

dependencies {
    minecraft("net.minecraftforge:forge:1.19.2-43.1.65")
    annotationProcessor("org.spongepowered:mixin:0.8.5:processor")
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

fun DependencyHandler.minecraft(
    dependencyNotation: Any
): Dependency = add("minecraft", dependencyNotation)!!

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}