package com.pleahmacaka.examplemod.common.items.tools

import com.pleahmacaka.examplemod.common.init.ExampleCreativeModTab
import net.minecraft.world.item.AxeItem
import net.minecraft.world.item.Tiers

object ExampleAxe : AxeItem(
    Tiers.NETHERITE, 5f, 3.0f, // why float?
    Properties()
        .tab(ExampleCreativeModTab)
) {
}