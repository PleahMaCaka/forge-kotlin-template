package com.pleahmacaka.examplemod.common.init

import com.pleahmacaka.examplemod.ExampleMod
import com.pleahmacaka.examplemod.common.blocks.ExampleBlock
import com.pleahmacaka.examplemod.common.blocks.ExampleOre
import com.pleahmacaka.examplemod.common.items.ExplosionStick
import com.pleahmacaka.examplemod.common.items.SadObsidianMaker
import com.pleahmacaka.examplemod.common.items.tools.*
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
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

    // Foods
    val EXAMPLE_FOOD = ITEMS.register<Item>("example_food") { Item(Item.Properties().tab(ExampleCreativeModTab)
        .food(FoodProperties.Builder().nutrition(2).saturationMod(0.2f).build())) }!!

    // ETC
    val EXPLOSION_STICK = ITEMS.register<Item>("explosion_stick") { ExplosionStick }!!
    val SAD_OBSIDIAN_MAKER = ITEMS.register<Item>("sad_obsidian_maker") { SadObsidianMaker }!!

    val EXAMPLE_INGOT = ITEMS.register<Item>("example_ingot") { Item(Item.Properties().tab(ExampleCreativeModTab)) }!!

    // BlockItems
    val EXAMPLE_BLOCK = ITEMS.register<BlockItem>("example_block") { BlockItem(ExampleBlock, Item.Properties().tab(ExampleCreativeModTab)) }!!
    val EXAMPLE_ORE = ITEMS.register<BlockItem>("example_ore") { BlockItem(ExampleOre, Item.Properties().tab(ExampleCreativeModTab)) }!!
}