package com.pleahmacaka.examplemod.common.blocks

import net.minecraft.world.level.block.OreBlock
import net.minecraft.world.level.material.Material

object ExampleOre : OreBlock(
    Properties
        .of(Material.STONE)
        .instabreak()
) {
}