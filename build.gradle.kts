import net.minecraftforge.gradle.common.util.MinecraftExtension
import org.spongepowered.asm.gradle.plugins.MixinExtension
import org.spongepowered.asm.gradle.plugins.struct.DynamicProperties
import java.text.SimpleDateFormat
import java.util.*

buildscript {
    repositories {
        maven("https://maven.minecraftforge.net")
        maven("https://maven.parchmentmc.org")
        mavenCentral()
    }
    dependencies {
        classpath("net.minecraftforge.gradle:ForgeGradle:5.1+")
        // Make sure this version matches the one included in Kotlin for Forge
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
        classpath("org.parchmentmc:librarian:1.+")

        // Mixin
        classpath("org.spongepowered:mixingradle:0.7.+")
    }
}

apply(plugin = "net.minecraftforge.gradle")
apply(plugin = "org.parchmentmc.librarian.forgegradle")
apply(plugin = "kotlin")

// Mixin Gradle
apply(plugin = "org.spongepowered.mixin")

plugins {
    eclipse
    `maven-publish`
    kotlin("jvm") version "1.5.10"
}

version = "1.18.1-0.0.1.0"
group = "com.pleahmacaka"
val parchmentDate = "2021.12.19"

val kotlin_version = "1.5.10"
val coroutines_version = "1.5.2"
val serialization_version = "1.3.1"

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
    // Change to your preferred mappings
    // mappings("official", "1.18.1")
    // Add your AccessTransformer
    mappings("parchment", "$parchmentDate-1.18.1")

    accessTransformer(file("src/main/resources/META-INF/accesstransformer.cfg"))

    runs.create("client") {
        workingDirectory(project.file("run"))
        property("forge.logging.console.level", "debug")
        this.mods {
            this.create("examplemod") {
                this.source(sourceSets.main.get())
            }
        }
    }

    runs.create("server") {
        workingDirectory(project.file("run"))
        property("forge.logging.console.level", "debug")
        this.mods {
            this.create("examplemod") {
                this.source(sourceSets.main.get())
            }
        }
    }

    runs.create("data") {
        workingDirectory(project.file("run"))
        property("forge.logging.console.level", "debug")
        args(
            "--mod",
            "examplemod",
            "--all",
            "--output",
            file("src/generated/resources/"),
            "--existing",
            file("src/main/resources")
        )
        this.mods {
            this.create("examplemod") {
                this.source(sourceSets.main.get())
            }
        }
    }
}

configurations {

    val library = this.maybeCreate("library")

    implementation.configure {
        extendsFrom(library)
    }
}
minecraft.runs.all {
    lazyToken("minecraft_classpath") {
        val joined =
            configurations.getByName("library").copyRecursive().resolve()
                // IMGUI
                // .filter { !(it.absolutePath.contains("lwjgl") && it.absolutePath.contains("3.2.3")) }
                .joinToString(File.pathSeparator) { it.absolutePath }
        println(joined)
        return@lazyToken joined
    }
}

/* IMGUI
val nativesType: String = when (OperatingSystem.current()) {
    OperatingSystem.LINUX -> "natives-linux"
    OperatingSystem.WINDOWS -> "natives-windows"
    else -> throw `java.lang`.IllegalStateException("This mod cannot be run on current environment!")
}
*/

repositories {
    mavenCentral()
    jcenter()
    maven(
        url = "https://thedarkcolour.github.io/KotlinForForge/"
    )
}

// val imguiVersion = "1.85.0"

dependencies {
    // Use the latest version of Minecraft Forge
    minecraft("net.minecraftforge:forge:1.18.1-39.0.44")

    // Apply Mixin AP
    annotationProcessor("org.spongepowered:mixin:0.8.5:processor")
    // clientAnnotationProcessor("org.spongepowered:mixin:0.8.5:processor")
    // apiAnnotationProcessor("org.spongepowered:mixin:0.8.5:processor")

    /* IMGUI
    library("io.github.spair:imgui-java-binding:$imguiVersion")

    library("io.github.spair:imgui-java-lwjgl3:$imguiVersion")

    val _322_ = "3.2.2"

    implementation(group = "org.lwjgl", name = "lwjgl", version = _322_) {
        isForce = true
    }
    implementation(group = "org.lwjgl", name = "lwjgl-glfw", version = _322_) {
        isForce = true
    }
    implementation(group = "org.lwjgl", name = "lwjgl-jemalloc", version = _322_) {
        isForce = true
    }
    implementation(group = "org.lwjgl", name = "lwjgl-openal", version = _322_) {
        isForce = true
    }
    implementation(group = "org.lwjgl", name = "lwjgl-opengl", version = _322_) {
        isForce = true
    }
    implementation(group = "org.lwjgl", name = "lwjgl-stb", version = _322_) {
        isForce = true
    }
    implementation(group = "org.lwjgl", name = "lwjgl-tinyfd", version = _322_) {
        isForce = true
    }

    library("io.github.spair:imgui-java-natives-linux:$imguiVersion")
    */

    implementation("thedarkcolour:kotlinforforge:3.0.0")

    val excluded = Action<ExternalModuleDependency>() {
        exclude(group = "org.jetbrains", module = "annotations")
    }

    library(
        group = "org.jetbrains.kotlin",
        name = "kotlin-stdlib-jdk8",
        version = kotlin_version,
        dependencyConfiguration = excluded
    )
    library(
        group = "org.jetbrains.kotlin",
        name = "kotlin-reflect",
        version = kotlin_version,
        dependencyConfiguration = excluded
    )
    library(
        group = "org.jetbrains.kotlinx",
        name = "kotlinx-coroutines-core",
        version = coroutines_version,
        dependencyConfiguration = excluded
    )
    library(
        group = "org.jetbrains.kotlinx",
        name = "kotlinx-coroutines-jdk8",
        version = coroutines_version,
        dependencyConfiguration = excluded
    )
    library(
        group = "org.jetbrains.kotlinx",
        name = "kotlinx-serialization-json",
        version = serialization_version,
        dependencyConfiguration = excluded
    )
}

mixin.run {
    add(sourceSets.main.get(), "mixins.examplemod.refmap.json")
    config("mixin.examplemod.json")

    // Deleted when released
    val debug = this.debug as DynamicProperties
    debug.setProperty("verbose", true)
    debug.setProperty("export", true)
    setDebug(debug)
}

// Include assets and data from data generators
sourceSets.main.configure {
    resources.srcDirs("src/generated/resources/")
}


tasks.withType<Jar> {
    archiveBaseName.set("examplemod")
    manifest {
        val map = HashMap<String, String>()
        map["Specification-Title"] = "examplemod"
        map["Specification-Vendor"] = "PleahMaCaka"
        map["Specification-Version"] = "1"
        map["Implementation-Title"] = project.name
        map["Implementation-Version"] = archiveBaseName.get()
        map["Implementation-Vendor"] = "PleahMaCaka"
        map["Implementation-Timestamp"] = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(Date())
        attributes(map)
    }
    finalizedBy("reobfJar")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = "17"
    }
}

fun DependencyHandler.minecraft(
    dependencyNotation: Any
): Dependency = add("minecraft", dependencyNotation)!!


fun DependencyHandler.library(
    dependencyNotation: Any
): Dependency = add("library", dependencyNotation)!!

fun DependencyHandler.library(
    group: String,
    name: String,
    version: String? = null,
    configuration: String? = null,
    classifier: String? = null,
    ext: String? = null,
    dependencyConfiguration: Action<ExternalModuleDependency>? = null
): ExternalModuleDependency = org.gradle.kotlin.dsl.accessors.runtime.addExternalModuleDependencyTo(
    this, "library", group, name, version, configuration, classifier, ext, dependencyConfiguration
)
