package com.pleahmacaka.examplemod.common.items

import com.pleahmacaka.examplemod.common.init.ExampleCreativeModTab
import net.minecraft.world.InteractionResult
import net.minecraft.world.item.Item
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.Explosion
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks


object ExplosionStick : Item(
    Properties()
        .tab(ExampleCreativeModTab)
) {
    override fun useOn(context: UseOnContext): InteractionResult {
        val level: Level = context.level
        val blockPos = context.clickedPos
        if (level.getBlockState(blockPos).block !== Blocks.AIR && !level.isClientSide()) {
            level.explode(
                context.player,
                blockPos.x.toDouble(),
                blockPos.y.toDouble(),
                blockPos.z.toDouble(),
                10.0f,
                Explosion.BlockInteraction.BREAK
            )
        }
        return InteractionResult.SUCCESS
    }
}