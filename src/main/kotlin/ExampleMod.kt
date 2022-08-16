package com.pleahmacaka.examplemod

import com.pleahmacaka.examplemod.common.init.BlockInit
import com.pleahmacaka.examplemod.common.init.ExampleCreativeTab
import com.pleahmacaka.examplemod.common.init.ItemInit
import com.pleahmacaka.examplemod.common.keybind.KeyBindHandler.registerKeybindings
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS

const val MODID = "examplemod"

@Mod(MODID)
object ExampleMod {

    private val LOGGER: Logger = LogManager.getLogger()

    init {
        LOGGER.log(Level.INFO, "$MODID has started!")

        MOD_BUS.addListener(::onClientSetup)
        MOD_BUS.addListener(::registerKeybindings)

        // Item / Register
        ItemInit.register(MOD_BUS)
        BlockInit.register(MOD_BUS)
    }

    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Initializing client... with ExampleMod!")
        ExampleCreativeTab
    }

}