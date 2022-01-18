package com.pleahmacaka.examplemod.common.datagen

import com.pleahmacaka.examplemod.common.init.ItemInit
import com.pleahmacaka.examplemod.common.items.ExplosionStick
import com.pleahmacaka.examplemod.common.items.tools.*
import net.minecraft.data.DataGenerator
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.world.item.Items
import net.minecraftforge.common.Tags
import java.util.function.Consumer

class ExampleRecipeProvider(pGenerator: DataGenerator) : RecipeProvider(pGenerator) {

    override fun buildCraftingRecipes(pFinishedRecipeConsumer: Consumer<FinishedRecipe>) {

        // Example tools
        ShapedRecipeBuilder.shaped(ExampleAxe)
            .define('#', Tags.Items.RODS_WOODEN)
            .define('X', ItemInit.EXAMPLE_INGOT.get())
            .pattern("XX")
            .pattern("X#")
            .pattern(" #")
            .unlockedBy("has_example_ingot", has(ItemInit.EXAMPLE_INGOT.get()))
            .save(pFinishedRecipeConsumer)

        ShapedRecipeBuilder.shaped(ExampleHoe)
            .define('#', Tags.Items.RODS_WOODEN)
            .define('X', ItemInit.EXAMPLE_INGOT.get())
            .pattern("XX")
            .pattern(" #")
            .pattern(" #")
            .unlockedBy("has_example_ingot", has(ItemInit.EXAMPLE_INGOT.get()))
            .save(pFinishedRecipeConsumer)

        ShapedRecipeBuilder.shaped(ExamplePickaxe)
            .define('#', Tags.Items.RODS_WOODEN)
            .define('X', ItemInit.EXAMPLE_INGOT.get())
            .pattern("XXX").pattern(" # ")
            .pattern(" # ")
            .unlockedBy("has_example_ingot", has(ItemInit.EXAMPLE_INGOT.get()))
            .save(pFinishedRecipeConsumer)

        ShapedRecipeBuilder.shaped(ExampleShovel)
            .define('#', Tags.Items.RODS_WOODEN)
            .define('X', ItemInit.EXAMPLE_INGOT.get())
            .pattern("X")
            .pattern("#")
            .pattern("#")
            .unlockedBy("has_example_ingot", has(ItemInit.EXAMPLE_INGOT.get()))
            .save(pFinishedRecipeConsumer)

        ShapedRecipeBuilder.shaped(ExampleSword)
            .define('#', Tags.Items.RODS_WOODEN)
            .define('X', ItemInit.EXAMPLE_INGOT.get())
            .pattern("X")
            .pattern("X")
            .pattern("#")
            .unlockedBy("has_example_ingot", has(ItemInit.EXAMPLE_INGOT.get()))
            .save(pFinishedRecipeConsumer)

        ShapedRecipeBuilder.shaped(ExplosionStick)
            .define('#', Tags.Items.RODS_WOODEN)
            .define('O', Items.FIRE_CHARGE)
            .define('X', ItemInit.EXAMPLE_INGOT.get())
            .pattern("XOX")
            .pattern(" # ")
            .pattern(" # ")
            .unlockedBy("has_example_ingot", has(ItemInit.EXAMPLE_INGOT.get()))
            .save(pFinishedRecipeConsumer)
    }

}