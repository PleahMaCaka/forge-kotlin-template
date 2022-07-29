package com.pleahmacaka.examplemod.init

import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items

object ExampleCreativeModTab : CreativeModeTab("examplemod") {

    override fun makeIcon(): ItemStack {
        return ItemStack(Items.DIAMOND)
    }

}