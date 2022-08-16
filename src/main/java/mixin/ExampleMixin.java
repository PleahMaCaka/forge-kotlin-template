package mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.User;
import net.minecraft.client.main.GameConfig;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.io.File;

@Mixin(Minecraft.class)
public class ExampleMixin {
    @Shadow
    @Final
    private User user;

    @Inject(at = @At("RETURN"), method = "<init>(Lnet/minecraft/client/main/GameConfig;)V", locals = LocalCapture.CAPTURE_FAILHARD)
    private void init(GameConfig gameConfig, CallbackInfo callbackInfo, File file1) {
        System.out.println("Mixin : Hello Forge Template!");
        System.out.println("Mixin : Hello " + this.user.getName() + "!");
        System.out.println("Mixin : Asset Dir - " + file1.getAbsolutePath());
    }
}