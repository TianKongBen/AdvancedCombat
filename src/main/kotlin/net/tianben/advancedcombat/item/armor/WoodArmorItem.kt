package net.tianben.advancedcombat.item.armor

import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.world.World

class WoodArmorItem(
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
        tooltip.add(Text.translatable("tooltip.advancedcombat.flammable").formatted(Formatting.RED))
        tooltip.add(Text.translatable("tooltip.advancedcombat.ecological_ii").formatted(Formatting.GREEN))
        super.appendTooltip(stack, world, tooltip, context)
    }

    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        super.inventoryTick(stack, world, entity, slot, selected)

        if (!world.isClient && entity is PlayerEntity) {
            if (!isWearingArmor(entity, stack)) return

            if (entity.isOnFire && world.time % 4 == 0L) {
                stack.damage(1, entity) { p -> p.sendEquipmentBreakStatus(slotType) }
            }

            if (stack.damage > 0) {
                val interval = if (entity.isWet) 20 else 240
                if (world.time % interval == 0L) {
                    stack.damage -= 1
                }
            }
        }
    }

    private fun isWearingArmor(player: PlayerEntity, stack: ItemStack): Boolean {
        return player.inventory.getArmorStack(
            type.equipmentSlot.entitySlotId
        ) == stack
    }
}