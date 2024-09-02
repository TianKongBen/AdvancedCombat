package net.tianben.advancedcombat.compat.jei

import mezz.jei.api.IModPlugin
import mezz.jei.api.JeiPlugin
import mezz.jei.api.registration.IRecipeCategoryRegistration
import mezz.jei.api.registration.IRecipeRegistration
import net.minecraft.util.Identifier
import net.tianben.advancedcombat.AdvancedCombat

@JeiPlugin
class JEIPlugin : IModPlugin {
    companion object {
        private val PLUGIN_ID = Identifier(AdvancedCombat.MOD_ID, "jei_plugin")
    }

    override fun registerCategories(registration: IRecipeCategoryRegistration) {
        registration.addRecipeCategories(
            EnchantmentUpgradeCategoryJEI(registration.jeiHelpers.guiHelper)
        )
    }

    override fun registerRecipes(registration: IRecipeRegistration) {
        registration.addRecipes(
            EnchantmentUpgradeCategoryJEI.TYPE,
            RecipeEnchantmentUpgradeJEI.recipeList
        )
    }

    override fun getPluginUid(): Identifier {
        return PLUGIN_ID
    }
}