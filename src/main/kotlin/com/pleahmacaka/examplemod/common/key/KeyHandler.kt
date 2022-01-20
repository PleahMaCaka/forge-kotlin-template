package com.pleahmacaka.examplemod.common.key

import com.mojang.blaze3d.platform.InputConstants
import com.pleahmacaka.examplemod.common.key.KeyBindings.KB_EXAMPLE_KEYBIND_AWESOME
import com.pleahmacaka.examplemod.common.key.KeyBindings.KB_EXAMPLE_KEYBIND_ONE
import com.pleahmacaka.examplemod.common.key.KeyBindings.KB_EXAMPLE_KEYBIND_TWO
import com.pleahmacaka.examplemod.common.key.KeyBindings.KEYBINDINGS
import net.minecraft.Util
import net.minecraft.client.KeyMapping
import net.minecraft.client.Minecraft
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.player.Player
import net.minecraftforge.client.event.InputEvent
import org.lwjgl.glfw.GLFW

object KeyHandler {

    fun onKeyInput(event: InputEvent.KeyInputEvent) {

        if (InputConstants.isKeyDown(Minecraft.getInstance().window.window, GLFW.GLFW_KEY_F3)) return

        val key = KEYBINDINGS.find { keyMapping ->
            keyMapping.key.value == event.key
        }

        if (key != null && key.keyConflictContext.isActive && key.keyModifier.isActive(key.keyConflictContext)) {
            when (event.action) {
                GLFW.GLFW_PRESS -> {
                    pressed(key)
                }
            }
        }
    }

    private fun pressed(kb: KeyMapping) {

        val player: Player = Minecraft.getInstance().player ?: return

        when {
            kb === KB_EXAMPLE_KEYBIND_ONE -> {
                player.sendMessage(Component.nullToEmpty("EXAMPLE KEYBIND ONE!"), Util.NIL_UUID)
            }

            kb === KB_EXAMPLE_KEYBIND_TWO -> {
                player.sendMessage(Component.nullToEmpty("EXAMPLE KEYBIND TWO!"), Util.NIL_UUID)
            }

            kb === KB_EXAMPLE_KEYBIND_AWESOME -> {
                player.deltaMovement = player.deltaMovement.add(0.0, 5.0, 0.0)
                player.hurtMarked = true
            }
        }
    }

}