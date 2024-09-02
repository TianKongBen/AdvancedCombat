package net.tianben.advancedcombat.compat.jei

import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.tianben.advancedcombat.enchanted.EnchantUpgrade
import net.tianben.advancedcombat.item.ModItems

class RecipeEnchantmentUpgradeJEI(val item: ItemStack, val upgrade: ItemStack, val output: ItemStack) {
    val inputs: List<ItemStack>
        get() {
            val inputs = mutableListOf<ItemStack>()
            inputs.add(this.item)
            inputs.add(this.upgrade)
            for (i in 2 until 9) {
                inputs.add(ItemStack.EMPTY)
            }
            return inputs
        }

    companion object {
        val recipeList: List<RecipeEnchantmentUpgradeJEI>
            get() {
                val allRecipes = mutableListOf<RecipeEnchantmentUpgradeJEI>()
                for (upgradeItem in ModItems.getAllEnchantUpgrades()) {
                    if (upgradeItem is EnchantUpgrade) {
                        val enchantment = upgradeItem.getEnchantment()
                        val enchantableitems = getAllEnchantableItems(enchantment)
                        for (baseItem in enchantableitems) {
                            for (level in upgradeItem.getMin()..upgradeItem.getMax()) {
                                val input = addEnchantment(baseItem.copy(), enchantment, level - 1)
                                val output = addEnchantment(baseItem.copy(), enchantment, level)
                                allRecipes.add(RecipeEnchantmentUpgradeJEI(input, ItemStack(upgradeItem), output))
                            }
                        }
                    }
                }
                return allRecipes
            }

        private fun getAllEnchantableItems(enchantment: Enchantment): List<ItemStack> {
            val items = mutableListOf<ItemStack>()
            for (item in Registries.ITEM) {
                val stack = ItemStack(item)
                if (enchantment.isAcceptableItem(stack)) {
                    items.add(stack)
                }
            }
            return items
        }

        private fun addEnchantment(stack: ItemStack, enchantment: Enchantment, level: Int): ItemStack {
            if (level > 0) {
                val enchantments = EnchantmentHelper.get(stack).toMutableMap()
                enchantments[enchantment] = level
                EnchantmentHelper.set(enchantments, stack)
            }
            return stack
        }
    }
}