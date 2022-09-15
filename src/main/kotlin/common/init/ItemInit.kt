@file:Suppress("HasPlatformType", "unused")

package com.pleahmacaka.examplemod.common.init

import com.pleahmacaka.examplemod.MODID
import com.pleahmacaka.examplemod.common.item.SadObsidianMaker
import com.pleahmacaka.examplemod.common.item.TestSword
import net.minecraft.world.item.Item
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object ItemInit {

    // for register
    private val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, MODID)

    fun register(bus: IEventBus) = ITEMS.register(bus)

    // ==================== //
    //     Normal Items     //
    // ==================== //

    val SAD_OBSIDIAN_MAKER = ITEMS.register("sad_obsidian_maker") { SadObsidianMaker }

    val TEST_SWORD = ITEMS.register("test_sword") { TestSword }


}