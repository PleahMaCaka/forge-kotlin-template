package com.pleahmacaka.examplemod.common.keybind

import com.pleahmacaka.examplemod.common.keybind.KeyBinds.KB_EXAMPLE_KEYBIND_ONE
import com.pleahmacaka.examplemod.common.keybind.KeyBinds.KB_EXAMPLE_KEYBIND_TWO
import com.pleahmacaka.examplemod.common.keybind.KeyBinds.KEYBINDINGS
import net.minecraft.client.KeyMapping
import net.minecraft.client.Minecraft
import net.minecraft.client.player.LocalPlayer
import net.minecraft.network.chat.Component
import net.minecraftforge.client.event.InputEvent
import net.minecraftforge.client.event.RegisterKeyMappingsEvent
import org.lwjgl.glfw.GLFW
import thedarkcolour.kotlinforforge.forge.FORGE_BUS

object KeyBindHandler {

    private fun onKeyInput(event: InputEvent.Key) {
        val key = KEYBINDINGS.find { keyMapping ->
            keyMapping.key.value == event.key
        } ?: return

        when (event.action) {
            GLFW.GLFW_PRESS -> {
                pressed(key)
            }
        }
    }

    private fun pressed(kb: KeyMapping) {
//        val minecraft: Minecraft = Minecraft.getInstance() ?: return
        val player: LocalPlayer = Minecraft.getInstance().player ?: return

        when (kb) {
            KB_EXAMPLE_KEYBIND_ONE -> player.sendSystemMessage(Component.nullToEmpty("one!"))

            KB_EXAMPLE_KEYBIND_TWO -> player.sendSystemMessage(Component.nullToEmpty("two!"))
        }
    }

    fun registerKeybindings(event: RegisterKeyMappingsEvent) {
        FORGE_BUS.addListener(KeyBindHandler::onKeyInput)
        KEYBINDINGS.forEach { event.register(it) }
    }

}