package net.tianben.advancedcombat.enchanted

import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterial

class EnchantedSwordItem(toolMaterial: ToolMaterial, attackDamage: Int, attackSpeed: Float, settings: Settings) :
    SwordItem(toolMaterial, attackDamage, attackSpeed, settings) {
    override fun hasGlint(stack: ItemStack?): Boolean {
        return true
    }
}

