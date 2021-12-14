package com.pleahmacaka.examplemod.common.blocks

import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material

object ExampleBlock : Block(
    BlockBehaviour.Properties
        .of(Material.STONE)
        .instabreak()
        .friction(10f)
) {
}