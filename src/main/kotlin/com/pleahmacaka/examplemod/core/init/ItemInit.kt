package com.pleahmacaka.examplemod.core.init

import com.pleahmacaka.examplemod.ExampleMod
import com.pleahmacaka.examplemod.common.blocks.ExampleBlock
import com.pleahmacaka.examplemod.common.items.*
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.ShovelItem
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object ItemInit {

    private val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID)

    fun register(bus: IEventBus) { ITEMS.register(bus) }

    // Items
    val EXAMPLE_SWORD = ITEMS.register<Item>("example_sword") { ExampleSword }!!
    val EXAMPLE_PICKAXE = ITEMS.register<Item>("example_pickaxe") { ExamplePickaxe }!!
    val EXAMPLE_AXE = ITEMS.register<Item>("example_axe") { ExampleAxe }!!
    val EXAMPLE_SHOVEL = ITEMS.register<Item>("example_shovel") { ExampleShovel }!!
    val EXAMPLE_HOE = ITEMS.register<Item>("example_hoe") { ExampleHoe }!!

    val EXAMPLE_FOOD = ITEMS.register<Item>("example_food") { ExampleFood }!!

    // BlockItems
    val EXAMPLE_BLOCK = ITEMS.register<BlockItem>("example_block") { BlockItem(ExampleBlock, Item.Properties().tab(ExampleCreativeModTab)) }!!
}