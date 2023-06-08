package com.pleahmacaka.examplemod

import com.pleahmacaka.examplemod.init.BlockItemRegistry
import com.pleahmacaka.examplemod.init.BlockRegistry
import com.pleahmacaka.examplemod.init.ItemRegistry
import com.pleahmacaka.examplemod.keybind.KeyBindHandler.registerKeybindings
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS

const val MODID = "examplemod"

@Mod(MODID)
object ExampleMod {

    val LOGGER: Logger = LogManager.getLogger("examplemod")

    init {
        LOGGER.log(Level.INFO, "$MODID has started!")

        MOD_BUS.addListener(::onClientSetup)

        ItemRegistry.register(MOD_BUS)
        BlockRegistry.register(MOD_BUS)
        BlockItemRegistry.register(MOD_BUS)
    }

    @Suppress("UNUSED_PARAMETER")
    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Initializing client... with ExampleMod!")
        MOD_BUS.addListener(::registerKeybindings)
    }

}