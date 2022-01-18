package com.pleahmacaka.examplemod.common.datagen

import net.minecraftforge.forge.event.lifecycle.GatherDataEvent

fun setupDataGen(event: GatherDataEvent) {

    val generator = event.generator

    if (event.includeServer()) {
        generator.addProvider(ExampleRecipeProvider(generator))
    }
    
    // if (event.includeClient()) { ... }
}