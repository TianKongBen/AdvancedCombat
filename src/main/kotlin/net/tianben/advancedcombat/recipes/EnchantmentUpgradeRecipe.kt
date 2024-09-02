package net.tianben.advancedcombat.recipes

import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.inventory.RecipeInputInventory
import net.minecraft.item.ItemStack
import net.minecraft.recipe.RecipeSerializer
import net.minecraft.recipe.SpecialCraftingRecipe
import net.minecraft.recipe.book.CraftingRecipeCategory
import net.minecraft.registry.DynamicRegistryManager
import net.minecraft.util.Identifier
import net.minecraft.world.World
import net.tianben.advancedcombat.enchanted.EnchantUpgrade

class EnchantmentUpgradeRecipe(id: Identifier, category: CraftingRecipeCategory) : SpecialCraftingRecipe(id, category) {

    override fun matches(inventory: RecipeInputInventory, world: World): Boolean {
        var upgradeStack = ItemStack.EMPTY
        var targetStack = ItemStack.EMPTY

        for (i in 0 until inventory.size()) {
            val stack = inventory.getStack(i)
            if (stack.isEmpty) continue

            if (stack.item is EnchantUpgrade) {
                if (!upgradeStack.isEmpty) return false
                upgradeStack = stack
            } else {
                if (!targetStack.isEmpty) return false
                targetStack = stack
            }
        }

        if (upgradeStack.isEmpty || targetStack.isEmpty) return false

        val upgrade = upgradeStack.item as EnchantUpgrade
        val enchantment = upgrade.getEnchantment()
        val currentLevel = EnchantmentHelper.getLevel(enchantment, targetStack)

        return enchantment.isAcceptableItem(targetStack) &&
                currentLevel + 1 >= upgrade.getMin() &&
                currentLevel + 1 <= upgrade.getMax()
    }

    override fun craft(inventory: RecipeInputInventory, registryManager: DynamicRegistryManager): ItemStack {
        var upgradeStack = ItemStack.EMPTY
        var targetStack = ItemStack.EMPTY

        for (i in 0 until inventory.size()) {
            val stack = inventory.getStack(i)
            if (stack.isEmpty) continue

            if (stack.item is EnchantUpgrade) {
                upgradeStack = stack
            } else {
                targetStack = stack.copy()
            }
        }

        if (targetStack.isEmpty) return ItemStack.EMPTY

        val upgrade = upgradeStack.item as EnchantUpgrade
        val enchantment = upgrade.getEnchantment()
        val enchants = EnchantmentHelper.get(targetStack).toMutableMap()

        enchants.merge(enchantment, 1) { oldValue, newValue -> oldValue + newValue }
        EnchantmentHelper.set(enchants, targetStack)

        return targetStack
    }

    override fun fits(width: Int, height: Int): Boolean {
        return width * height >= 2
    }

    override fun getSerializer(): RecipeSerializer<*> {
        return ModRecipes.ENCHANTMENT_UPGRADE_SERIALIZER
    }
}