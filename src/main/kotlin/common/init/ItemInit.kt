package com.pleahmacaka.examplemod.common.init

import com.pleahmacaka.examplemod.ExampleMod
import com.pleahmacaka.examplemod.common.items.SadObsidianMaker
import net.minecraft.world.item.Item
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object ItemInit {

    private val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID)

    fun register(bus: IEventBus) = ITEMS.register(bus)

    // Items
    val SAD_OBSIDIAN_MAKER = ITEMS.register<Item>("sad_obsidian_maker") { SadObsidianMaker }
}