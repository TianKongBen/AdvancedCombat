package net.tianben.advancedcombat.item.shield

import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.item.ShieldItem

class AdvancedShieldItem : ShieldItem(Settings().maxDamage(1536)) {
    override fun canRepair(stack: ItemStack, ingredient: ItemStack): Boolean {
        return ingredient.isOf(Items.IRON_BLOCK) || super.canRepair(stack, ingredient)
    }
}