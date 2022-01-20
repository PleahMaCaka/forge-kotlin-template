package com.pleahmacaka.examplemod

import com.pleahmacaka.examplemod.common.datagen.setupDataGen
import com.pleahmacaka.examplemod.common.init.BlockInit
import com.pleahmacaka.examplemod.common.init.ItemInit
import com.pleahmacaka.examplemod.common.key.KeyBindings
import com.pleahmacaka.examplemod.common.key.KeyHandler
import net.minecraftforge.client.ClientRegistry
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.KotlinModLoadingContext


val MOD_BUS = KotlinModLoadingContext.get().getKEventBus()
val FORGE_BUS = MinecraftForge.EVENT_BUS!!

@Mod(ExampleMod.MODID)
object ExampleMod {

    // MY MODID
    const val MODID = "examplemod"

    // Directly reference a log4j logger.
    private val LOGGER: Logger = LogManager.getLogger()

    init {
        LOGGER.log(Level.INFO, "Example Mod has started!")

        MOD_BUS.addListener(::onClientSetup)
        FORGE_BUS.addListener(::onDedicatedServerSetupEvent)

        // dataGen - runData
        MOD_BUS.addListener(::setupDataGen)

        // Keybinding
        KeyBindings.KEYBINDINGS.forEach { ClientRegistry.registerKeyBinding(it) }
        FORGE_BUS.addListener(KeyHandler::onKeyInput)

        ItemInit.register(MOD_BUS)
        BlockInit.register(MOD_BUS)
    }

    /**
     * Initializing client
     * things such as renderers and keymaps
     * Fired on the mod specific event bus.
     */
    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Initializing client...")
    }

    /**
     * Fired on the global Forge bus.
     */
    private fun onDedicatedServerSetupEvent(event: FMLDedicatedServerSetupEvent) {
        LOGGER.log(Level.INFO, "Server starting...")
    }

}