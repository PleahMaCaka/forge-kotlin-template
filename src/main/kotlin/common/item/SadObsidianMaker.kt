package com.pleahmacaka.examplemod.common.item

import com.pleahmacaka.examplemod.ExampleCreativeTab
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.server.level.ServerLevel
import net.minecraft.sounds.SoundSource
import net.minecraft.world.InteractionResult
import net.minecraft.world.item.Item
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SoundType


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
            level.playSound(
                null,
                blockPos,
                SoundType.AMETHYST.placeSound,
                SoundSource.BLOCKS,
                1.0f,
                1.0f
            )
            (level as ServerLevel).sendParticles(
                ParticleTypes.LANDING_OBSIDIAN_TEAR,
                blockPos.x.toDouble() + 0.5,
                blockPos.y.toDouble() + 1,
                blockPos.z.toDouble() + 0.5,
                30,
                0.2,
                0.3,
                0.2,
                0.5
            )
        }
        return InteractionResult.SUCCESS
    }
}