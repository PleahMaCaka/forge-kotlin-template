package com.pleahmacaka.examplemod

import com.pleahmacaka.examplemod.keybind.KeyBindings.KB_EXAMPLE_KEYBIND_ONE
import com.pleahmacaka.examplemod.keybind.KeyBindings.KB_EXAMPLE_KEYBIND_TWO
import com.pleahmacaka.examplemod.keybind.KeyBindings.KEYBINDINGS
import net.minecraft.client.KeyMapping
import net.minecraft.client.Minecraft
import net.minecraft.client.player.LocalPlayer
import net.minecraftforge.client.event.InputEvent
import org.lwjgl.glfw.GLFW

object KeyBindHandler {

    fun onKeyInput(event: InputEvent.KeyInputEvent) {
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
            KB_EXAMPLE_KEYBIND_ONE -> player.chat("one pressed!")

            KB_EXAMPLE_KEYBIND_TWO -> player.chat("two pressed!")
        }
    }

}