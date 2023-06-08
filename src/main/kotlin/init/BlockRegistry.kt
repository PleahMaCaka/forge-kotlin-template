@file:Suppress("HasPlatformType", "unused")

package com.pleahmacaka.examplemod.init

import com.pleahmacaka.examplemod.MODID
import com.pleahmacaka.examplemod.blocks.ExampleBlock
import net.minecraft.world.level.block.Block
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object BlockRegistry {

    private val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID)

    fun register(bus: IEventBus) = BLOCKS.register(bus)

    // Example Block
    val EXAMPLE_BLOCK = BLOCKS.register<Block>("example_block") { ExampleBlock }

}