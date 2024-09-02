package net.tianben.advancedcombat.compat.rei

import me.shedaniel.math.Point
import me.shedaniel.math.Rectangle
import me.shedaniel.rei.api.client.gui.widgets.Slot
import me.shedaniel.rei.api.client.gui.widgets.Widget
import me.shedaniel.rei.api.client.gui.widgets.Widgets
import me.shedaniel.rei.api.client.registry.display.DisplayCategory
import me.shedaniel.rei.api.common.category.CategoryIdentifier
import me.shedaniel.rei.api.common.entry.EntryStack
import me.shedaniel.rei.api.common.util.EntryStacks
import net.minecraft.text.Text
import net.tianben.advancedcombat.AdvancedCombat
import net.tianben.advancedcombat.item.ModItems

class EnchantmentUpgradeCategoryREI : DisplayCategory<EnchantmentUpgradeDisplayREI> {
    companion object {
        val CATEGORY: CategoryIdentifier<EnchantmentUpgradeDisplayREI> =
            CategoryIdentifier.of(AdvancedCombat.MOD_ID, "advancedcombat")
    }

    override fun getCategoryIdentifier(): CategoryIdentifier<EnchantmentUpgradeDisplayREI> {
        return CATEGORY
    }

    override fun getTitle(): Text {
        return Text.translatable("category.advancedcombat.enchantment_upgrade")
    }

    override fun getIcon(): EntryStack<*> {
        return EntryStacks.of(ModItems.SHARPNESS_UPGRADE)
    }

    override fun setupDisplay(display: EnchantmentUpgradeDisplayREI, bounds: Rectangle): List<Widget> {
        val startPoint = Point(bounds.centerX - 58, bounds.centerY - 27)
        val widgets = mutableListOf<Widget>()

        widgets.add(Widgets.createRecipeBase(bounds))
        widgets.add(Widgets.createArrow(Point(startPoint.x + 60, startPoint.y + 18)))

        widgets.add(Widgets.createResultSlotBackground(Point(startPoint.x + 95, startPoint.y + 19)))

        val inputs = display.inputEntries
        for (y in 0..2) {
            for (x in 0..2) {
                val index = y * 3 + x
                val slot = Widgets.createSlot(Point(startPoint.x + 1 + x * 18, startPoint.y + 1 + y * 18))
                    .markInput()
                if (index < inputs.size) {
                    (slot as Slot).entries(inputs[index])
                }
                widgets.add(slot)
            }
        }

        widgets.add(Widgets.createSlot(Point(startPoint.x + 95, startPoint.y + 19))
            .entries(display.outputEntries[0])
            .markOutput()
            .disableBackground())

        return widgets
    }

    override fun getDisplayHeight(): Int {
        return 66
    }
}