package com.pleahmacaka.examplemod.event

import com.pleahmacaka.examplemod.MODID
import com.pleahmacaka.examplemod.common.block.ExampleBlock
import com.pleahmacaka.examplemod.common.init.BlockItemRegistry
import com.pleahmacaka.examplemod.common.item.SadObsidianMaker
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.flag.FeatureFlagSet
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraftforge.event.CreativeModeTabEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
object ExampleCreativeModTab {

    @SubscribeEvent
    fun buildContents(event: CreativeModeTabEvent.Register) {
        event.registerCreativeModeTab(ResourceLocation(MODID, "example")) { builder ->
            builder.title(Component.translatable("itemGroup.$MODID.exampletab"))
                .icon { ItemStack(ExampleBlock) }
                .displayItems { _: FeatureFlagSet?, output: CreativeModeTab.Output, _: Boolean ->
                    output.accept(SadObsidianMaker)
                    output.accept(BlockItemRegistry.EXAMPLE_BLOCK)
                }
        }
    }

}