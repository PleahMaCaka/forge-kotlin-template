package mixin.bindings;

import com.pleahmacaka.examplemod.mixin.ExampleMixinBindingKt;
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
public class ExampleBindingMixin {

    @Inject(at = @At("RETURN"), method = "<init>(Lnet/minecraft/client/main/GameConfig;)V", locals = LocalCapture.CAPTURE_FAILHARD)
    private void init(GameConfig gameConfig, CallbackInfo callbackInfo, File file1) {
        ExampleMixinBindingKt.exampleMixinBinding(/*gameConfig, callbackInfo, file1*/);
    }

}