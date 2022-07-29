package com.pleahmacaka.examplemod.mixin.bindings;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Entity.class)
public abstract class NoHitCoolDown {

    // Inject LivingEntity - canAttack and always return true
    @Accessor("invulnerable")
    public abstract boolean getInvulnerable();

    @Accessor("invulnerable")
    public abstract void setInvulnerable(boolean x);
}