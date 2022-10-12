package com.pleahmacaka.examplemod.common.item

import com.mojang.blaze3d.vertex.PoseStack
import com.mojang.math.Vector3f
import com.pleahmacaka.examplemod.ExampleCreativeTab
import com.pleahmacaka.examplemod.ExampleMod
import net.minecraft.client.model.HumanoidModel
import net.minecraft.client.model.HumanoidModel.ArmPose
import net.minecraft.client.player.LocalPlayer
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.HumanoidArm
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.entity.projectile.ProjectileUtil
import net.minecraft.world.item.AxeItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Tiers
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.Level
import net.minecraft.world.phys.AABB
import net.minecraftforge.client.extensions.common.IClientItemExtensions
import java.util.function.Consumer
import java.util.function.Predicate


object TestSword : AxeItem(
    Tiers.DIAMOND,
    3f,
    -3f,
    Properties()
        .tab(ExampleCreativeTab)
) {

    override fun useOn(context: UseOnContext): InteractionResult {
        ExampleMod.LOGGER.info("Use on")
        return super.useOn(context)
    }

    override fun use(level: Level, player: Player, usedHand: InteractionHand): InteractionResultHolder<ItemStack> {
        val logger = ExampleMod.LOGGER

        if (level.isClientSide()) return super.use(level, player, usedHand)

        val playerHeadPos = player.eyePosition
        val rayEndPos = playerHeadPos.add(player.lookAngle.scale(20.0))
        val searchRegionBox = AABB.ofSize(player.position(), 40.0, 40.0, 40.0)
        val predicate = Predicate<Entity> { true }
        val target = ProjectileUtil.getEntityHitResult(
            level,
            player,
            playerHeadPos,
            rayEndPos,
            searchRegionBox,
            predicate,
            0.5F
        )?.entity ?: return super.use(level, player, usedHand)

        target.deltaMovement = target.deltaMovement.add(0.0, 1.0, 0.0)
        logger.info("Target found ${target.name}!")
        return super.use(level, player, usedHand)
    }

    override fun initializeClient(consumer: Consumer<IClientItemExtensions>) {
        consumer.accept(object : IClientItemExtensions {
            override fun applyForgeHandTransform(
                poseStack: PoseStack,
                player: LocalPlayer,
                arm: HumanoidArm,
                itemInHand: ItemStack,
                partialTick: Float,
                equipProcess: Float,
                swingProcess: Float
            ): Boolean {
                val i = if (arm == HumanoidArm.RIGHT) 1 else -1
                poseStack.translate((i * 0.56f).toDouble(), -0.42, -0.72)
                if (equipProcess != 0.0f)
                    poseStack.mulPose(Vector3f.XP.rotationDegrees(-equipProcess * 90.0f))

                poseStack.mulPose(Vector3f.XN.rotationDegrees(-90.0f))
                poseStack.mulPose(Vector3f.XN.rotationDegrees(180.0f * equipProcess * equipProcess * equipProcess))
                return true
            }

            private val UNDER_SWORD = ArmPose.create(
                "UNDER_SWORD", false
            ) { model: HumanoidModel<*>, entity: LivingEntity?, arm: HumanoidArm ->
                if (arm == HumanoidArm.RIGHT)
                    model.rightArm.xRot = (Math.random() / 2 * Math.PI * 2).toFloat()
                else
                    model.leftArm.xRot = (Math.random() / 2 * Math.PI * 2).toFloat()
            }

            override fun getArmPose(
                entityLiving: LivingEntity?,
                hand: InteractionHand?,
                itemStack: ItemStack
            ): ArmPose {
                return if (itemStack.isEmpty) HumanoidModel.ArmPose.EMPTY
                else return UNDER_SWORD
            }
        })
    }
}