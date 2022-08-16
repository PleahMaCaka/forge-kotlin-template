package com.pleahmacaka.examplemod.common.item

import com.pleahmacaka.examplemod.common.init.ExampleCreativeTab
import net.minecraft.world.InteractionResult
import net.minecraft.world.item.Item
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Blocks


object SadObsidianMaker : Item(
    Properties()
        .tab(ExampleCreativeTab)
        .stacksTo(1)
) {
    override fun useOn(context: UseOnContext): InteractionResult {
        val level: Level = context.level
        val blockPos = context.clickedPos

        val selectedBlock = level.getBlockState(blockPos).block

        if (selectedBlock == Blocks.OBSIDIAN && !level.isClientSide()) {
            level.setBlock(blockPos, Blocks.CRYING_OBSIDIAN.defaultBlockState(), 1)
        }
        return InteractionResult.SUCCESS
    }
}