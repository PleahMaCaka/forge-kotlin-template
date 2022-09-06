@file:Suppress("unused", "HasPlatformType")

package com.pleahmacaka.examplemod.common.init

import com.pleahmacaka.examplemod.ExampleCreativeTab
import com.pleahmacaka.examplemod.MODID
import com.pleahmacaka.examplemod.common.block.ExampleBlock
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object BlockItemInit {

    private val BLOCK_ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MODID)

    // ==================== //
    //      Block Items     //
    // ==================== //

    val EXAMPLE_BLOCK =
        BLOCK_ITEMS.register("example_block") { BlockItem(ExampleBlock, Item.Properties().tab(ExampleCreativeTab)) }

}