package com.pleahmacaka.examplemod.mixin.event

import com.pleahmacaka.examplemod.ExampleMod
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
object NoHitCoolDown {

    @SubscribeEvent
    fun noHitCoolDown(event: LivingAttackEvent) {
        event.entity.invulnerableTime = 0
        event.entity.invulnerable = false
    }

}