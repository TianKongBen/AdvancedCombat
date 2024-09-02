package net.tianben.advancedcombat.item.armor

import net.minecraft.client.item.TooltipContext
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.world.World

class ObsidianArmorItem(
    material: ArmorMaterial,
    type: Type,
    settings: Settings
) : ArmorItem(material, type, settings) {

    override fun appendTooltip(
        stack: ItemStack,
        world: World?,
        tooltip: MutableList<Text>,
        context: TooltipContext
    ) {
        tooltip.add(Text.translatable("tooltip.advancedcombat.blastproof_ii").formatted(Formatting.BLUE))
        super.appendTooltip(stack, world, tooltip, context)
    }
}