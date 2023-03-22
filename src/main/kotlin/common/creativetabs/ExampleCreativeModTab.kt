package com.pleahmacaka.examplemod.common.creativetab

import com.pleahmacaka.examplemod.MODID
import com.pleahmacaka.examplemod.common.block.ExampleBlock
import com.pleahmacaka.examplemod.common.item.SadObsidianMaker
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack
import net.minecraftforge.event.CreativeModeTabEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Suppress("unused")
@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
object ExampleCreativeModTab {

    @SubscribeEvent
    fun buildContents(event: CreativeModeTabEvent.Register) {
        event.registerCreativeModeTab(ResourceLocation(MODID, "example")) { builder ->
            builder.title(Component.translatable("itemGroup.$MODID.exampletab"))
                .icon { ItemStack(ExampleBlock) }
                .displayItems { _, pOutput ->
                    pOutput.accept(ItemStack(ExampleBlock))
                    pOutput.accept(ItemStack(SadObsidianMaker))
                }
        }
    }

}