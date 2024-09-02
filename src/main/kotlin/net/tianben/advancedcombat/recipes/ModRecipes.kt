package net.tianben.advancedcombat.recipes

import net.minecraft.recipe.RecipeSerializer
import net.minecraft.recipe.SpecialRecipeSerializer
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.tianben.advancedcombat.AdvancedCombat

object ModRecipes {
    val ENCHANTMENT_UPGRADE_SERIALIZER: RecipeSerializer<EnchantmentUpgradeRecipe> =
        registerSerializer("enchantment_upgrade",
            SpecialRecipeSerializer(::EnchantmentUpgradeRecipe))

    private fun <T : RecipeSerializer<*>> registerSerializer(name: String, serializer: T): T {
        return Registry.register(Registries.RECIPE_SERIALIZER,
            Identifier(AdvancedCombat.MOD_ID, name), serializer)
    }

    fun registerModRecipesSerializers() {
        AdvancedCombat.LOGGER?.info("Registering Mod Recipe Serializers for " + AdvancedCombat.MOD_ID)
    }
}