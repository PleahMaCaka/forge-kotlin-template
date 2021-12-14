package com.pleahmacaka.examplemod.common.items

import com.pleahmacaka.examplemod.core.init.ExampleCreativeModTab
import net.minecraft.world.item.AxeItem
import net.minecraft.world.item.HoeItem
import net.minecraft.world.item.PickaxeItem
import net.minecraft.world.item.Tiers

object ExampleHoe : HoeItem(
    Tiers.NETHERITE, 5, 3.0f,
    Properties()
        .tab(ExampleCreativeModTab)
) {
}