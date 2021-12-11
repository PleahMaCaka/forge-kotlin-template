package com.pleahmacaka.examplemod.common.items

import com.pleahmacaka.examplemod.common.modinit.ExampleCreativeModTab
import net.minecraft.world.item.SwordItem
import net.minecraft.world.item.Tiers

object ExampleSword : SwordItem(
    Tiers.NETHERITE, 5, 3.0f,
    Properties()
        .tab(ExampleCreativeModTab)
) {
}