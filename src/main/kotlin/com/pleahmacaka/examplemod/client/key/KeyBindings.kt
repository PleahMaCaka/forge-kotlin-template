package com.pleahmacaka.examplemod.client.key

import com.mojang.blaze3d.platform.InputConstants
import net.minecraft.client.KeyMapping
import net.minecraftforge.client.settings.KeyConflictContext
import org.lwjgl.glfw.GLFW

object KeyBindings {

    private const val CATEGORY = "PleahMaCaka's Keybind"

    val KB_EXAMPLE_KEYBIND_ONE = KeyMapping(
        "Example Keybind One",
        KeyConflictContext.IN_GAME,
        InputConstants.Type.KEYSYM,
        GLFW.GLFW_KEY_C,
        CATEGORY
    )

    val KB_EXAMPLE_KEYBIND_TWO = KeyMapping(
        "Example Keybind Two",
        KeyConflictContext.IN_GAME,
        InputConstants.Type.KEYSYM,
        GLFW.GLFW_KEY_X,
        CATEGORY
    )

    val KB_EXAMPLE_KEYBIND_AWESOME = KeyMapping(
        "You can free your mind",
        KeyConflictContext.IN_GAME,
        InputConstants.Type.KEYSYM,
        GLFW.GLFW_KEY_V,
        CATEGORY
    )

    val KEYBINDINGS = hashSetOf(KB_EXAMPLE_KEYBIND_ONE, KB_EXAMPLE_KEYBIND_TWO, KB_EXAMPLE_KEYBIND_AWESOME)

}