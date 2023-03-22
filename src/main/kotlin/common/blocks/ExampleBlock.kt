package com.pleahmacaka.examplemod.common.block


import net.minecraft.world.level.block.Block
import net.minecraft.world.level.material.Material

object ExampleBlock : Block(
    Properties
        .of(Material.STONE)
        .instabreak()
        .friction(10f)
)