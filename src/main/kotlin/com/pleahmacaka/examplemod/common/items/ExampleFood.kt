package com.pleahmacaka.examplemod.common.items

import com.pleahmacaka.examplemod.core.init.ExampleCreativeModTab
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item

object ExampleFood : Item(
    Properties()
        .tab(ExampleCreativeModTab)
        .food(
            FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(0.2f)
                .build()
        )
) {
}