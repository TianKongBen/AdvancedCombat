package net.tianben.advancedcombat.compat.rei

import me.shedaniel.rei.api.client.plugins.REIClientPlugin
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry
import me.shedaniel.rei.api.common.util.EntryStacks
import net.minecraft.registry.Registries
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import net.tianben.advancedcombat.AdvancedCombat
import net.tianben.advancedcombat.compat.jei.RecipeEnchantmentUpgradeJEI

class REIPlugin : REIClientPlugin {
    override fun registerCategories(registry: CategoryRegistry) {
        registry.add(EnchantmentUpgradeCategoryREI())

        val upgradeTag = TagKey.of(Registries.ITEM.key,
            Identifier(AdvancedCombat.MOD_ID, "enchantment_upgrades"))
        Registries.ITEM.getEntryList(upgradeTag).ifPresent { entryList ->
            entryList.stream().forEach { entry ->
                registry.addWorkstations(
                    EnchantmentUpgradeCategoryREI.CATEGORY,
                    EntryStacks.of(entry.value())
                )
            }
        }
    }

    override fun registerDisplays(registry: DisplayRegistry) {
        RecipeEnchantmentUpgradeJEI.recipeList.forEach { recipe ->
            registry.add(EnchantmentUpgradeDisplayREI(recipe))
        }
    }
}