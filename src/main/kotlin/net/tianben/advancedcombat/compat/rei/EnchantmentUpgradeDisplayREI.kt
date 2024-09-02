package net.tianben.advancedcombat.compat.rei

import me.shedaniel.rei.api.common.category.CategoryIdentifier
import me.shedaniel.rei.api.common.display.basic.BasicDisplay
import me.shedaniel.rei.api.common.entry.EntryIngredient
import me.shedaniel.rei.api.common.util.EntryIngredients
import net.minecraft.util.Identifier
import net.tianben.advancedcombat.compat.jei.RecipeEnchantmentUpgradeJEI
import java.util.*

class EnchantmentUpgradeDisplayREI(recipe: RecipeEnchantmentUpgradeJEI) : BasicDisplay(
    getInputs(recipe),
    listOf(EntryIngredients.of(recipe.output))
) {
    override fun getCategoryIdentifier(): CategoryIdentifier<*> {
        return EnchantmentUpgradeCategoryREI.CATEGORY
    }

    override fun getDisplayLocation(): Optional<Identifier> {
        return Optional.of(Identifier("advancedcombat", "advancedcombat"))
    }

    companion object {
        private fun getInputs(recipe: RecipeEnchantmentUpgradeJEI): List<EntryIngredient> {
            val inputs = mutableListOf<EntryIngredient>()
            inputs.add(EntryIngredients.of(recipe.inputs[0]))
            inputs.add(EntryIngredients.of(recipe.inputs[1]))
            for (i in 2 until 9) {
                inputs.add(EntryIngredient.empty())
            }
            return inputs
        }
    }
}