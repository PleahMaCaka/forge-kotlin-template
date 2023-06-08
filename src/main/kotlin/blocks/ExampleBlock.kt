package com.pleahmacaka.examplemod.blocks


import net.minecraft.world.level.block.Block

object ExampleBlock : Block(
    Properties
        .of()
        .instabreak()
        .friction(10f)
)