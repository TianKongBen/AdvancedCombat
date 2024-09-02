package net.tianben.advancedcombat.enchanted

import net.minecraft.client.item.TooltipContext
import net.minecraft.enchantment.Enchantment
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Style
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.world.World

open class EnchantUpgrade(
    settings: Settings,
    private val applyEnchantment: Enchantment,
    private val minLvl: Int,
    private val maxlvl: Int,
    val enchantName: String,
    private val foil: Boolean
) : Item(settings) {

    override fun hasGlint(stack: ItemStack): Boolean {
        return foil
    }

    override fun appendTooltip(stack: ItemStack, world: World?,
                               tooltip: MutableList<Text>, context: TooltipContext) {
        super.appendTooltip(stack, world, tooltip, context)
        tooltip.add(Text.translatable("tooltip.advancedcombat.enchantment",
            Text.translatable(enchantName)).setStyle(Style.EMPTY.withColor(Formatting.GRAY)))
        tooltip.add(Text.translatable("tooltip.advancedcombat.tiers",
            minLvl, maxlvl).setStyle(Style.EMPTY.withColor(Formatting.GRAY)))
    }

    fun getEnchantment(): Enchantment {
        return applyEnchantment
    }

    fun getMin(): Int {
        return minLvl
    }

    fun getMax(): Int {
        return maxlvl
    }
}
