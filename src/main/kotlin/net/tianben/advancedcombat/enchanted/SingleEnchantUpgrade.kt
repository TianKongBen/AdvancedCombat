package net.tianben.advancedcombat.enchanted

import net.minecraft.client.item.TooltipContext
import net.minecraft.enchantment.Enchantment
import net.minecraft.item.ItemStack
import net.minecraft.text.Style
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.world.World

class SingleEnchantUpgrade(
    settings: Settings,
    enchantment: Enchantment,
    min: Int,
    max: Int,
    enchantName: String,
    foil: Boolean
) : EnchantUpgrade(settings, enchantment, min, max, enchantName, foil) {

    override fun appendTooltip(stack: ItemStack, world: World?,
                               tooltip: MutableList<Text>, context: TooltipContext) {
        tooltip.add(Text.translatable("tooltip.advancedcombat.enchantment",
            Text.translatable(this@SingleEnchantUpgrade.enchantName))
            .setStyle(Style.EMPTY.withColor(Formatting.GRAY)))
    }
}