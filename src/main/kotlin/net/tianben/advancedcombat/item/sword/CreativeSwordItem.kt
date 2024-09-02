package net.tianben.advancedcombat.item.sword

import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.minecraft.block.BlockState
import net.minecraft.client.MinecraftClient
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterial
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class CreativeSwordItem(
    material: ToolMaterial,
    attackDamage: Int,
    attackSpeed: Float,
    settings: Settings
) : SwordItem(material, attackDamage, attackSpeed, settings) {

    override fun postHit(stack: ItemStack, target: LivingEntity, attacker: LivingEntity): Boolean {
        if (attacker is PlayerEntity && attacker.isCreative) {
            target.kill()
            target.remove(Entity.RemovalReason.KILLED)
            return true
        }
        return super.postHit(stack, target, attacker)
    }

    override fun inventoryTick(stack: ItemStack, world: World, entity: Entity, slot: Int, selected: Boolean) {
        if (entity !is PlayerEntity || !entity.isCreative) {
            super.inventoryTick(stack, world, entity, slot, selected)
        } else {
            if (stack.damage > 0) stack.damage = 0
        }
    }

    override fun postMine(stack: ItemStack, world: World, state: BlockState, pos: BlockPos, miner: LivingEntity): Boolean {
        return if (miner is PlayerEntity && miner.isCreative) {
            true
        } else {
            super.postMine(stack, world, state, pos, miner)
        }
    }

    override fun canMine(state: BlockState, world: World, pos: BlockPos, miner: PlayerEntity): Boolean {
        return miner.isCreative || super.canMine(state, world, pos, miner)
    }

    @Environment(EnvType.CLIENT)
    override fun hasGlint(stack: ItemStack): Boolean {
        val player = MinecraftClient.getInstance().player
        return player != null && player.isCreative
    }

    @Environment(EnvType.CLIENT)
    override fun appendTooltip(stack: ItemStack, world: World?, tooltip: MutableList<Text>, context: TooltipContext) {
        val player = MinecraftClient.getInstance().player
        if (player != null && player.isCreative) {
            tooltip.add(Text.translatable("tooltip.advancedcombat.active").formatted(Formatting.GREEN))
        } else {
            tooltip.add(Text.translatable("tooltip.advancedcombat.inactive").formatted(Formatting.RED))
        }
    }
}