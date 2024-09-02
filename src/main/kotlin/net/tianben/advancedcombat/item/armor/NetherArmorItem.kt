package net.tianben.advancedcombat.item.armor

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.world.World

class NetherArmorItem(
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
        tooltip.add(Text.translatable("tooltip.advancedcombat.brick_wall").formatted(Formatting.GOLD))
        tooltip.add(Text.translatable("tooltip.advancedcombat.blastproof_i").formatted(Formatting.BLUE))
        super.appendTooltip(stack, world, tooltip, context)
    }

    companion object {
        private var witherListenerRegistered = false

        init {
            registerWitherListener()
        }

        private fun registerWitherListener() {
            if (!witherListenerRegistered) {
                ServerLivingEntityEvents.ALLOW_DAMAGE.register { entity, source, _ ->
                    if (source.attacker is LivingEntity) {
                        handleWitherEffect(entity, source.attacker as LivingEntity)
                    }
                    true
                }
                witherListenerRegistered = true
            }
        }

        private fun handleWitherEffect(victim: LivingEntity, attacker: LivingEntity) {
            if (victim === attacker) return
            val count = getWornNetherCount(victim)
            if (count > 0) {
                attacker.addStatusEffect(
                    StatusEffectInstance(
                        StatusEffects.WITHER,
                        count * 20,
                        if (count > 2) 1 else 0
                    )
                )
            }
        }

        private fun getWornNetherCount(entity: LivingEntity): Int {
            var count = 0
            for (stack in entity.armorItems) {
                if (stack.item is NetherArmorItem) count++
            }
            return count
        }
    }
}