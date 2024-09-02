package net.tianben.advancedcombat.item.bow

import net.minecraft.enchantment.EnchantmentHelper
import net.minecraft.enchantment.Enchantments
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.projectile.PersistentProjectileEntity
import net.minecraft.item.ArrowItem
import net.minecraft.item.BowItem
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.stat.Stats
import net.minecraft.world.World

class AdvancedBowItem : BowItem(Settings().maxDamage(1536)) {

    override fun onStoppedUsing(stack: ItemStack, world: World, user: LivingEntity, remainingUseTicks: Int) {
        if (user !is PlayerEntity) return

        val player = user
        val hasInfinity = player.abilities.creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0
        var projectileStack = player.getProjectileType(stack)

        if (projectileStack.isEmpty && !hasInfinity) return

        if (projectileStack.isEmpty) {
            projectileStack = ItemStack(Items.ARROW)
        }

        val useTime = getMaxUseTime(stack) - remainingUseTicks
        val pullProgress = getPullProgress(useTime)
        if (pullProgress < 0.1) return

        val isCreativeArrow = hasInfinity && projectileStack.isOf(Items.ARROW)

        if (!world.isClient) {
            val arrowItem = (if (projectileStack.item is ArrowItem) projectileStack.item else Items.ARROW) as ArrowItem
            val arrow = arrowItem.createArrow(world, projectileStack, player)

            arrow.setVelocity(player, player.pitch, player.yaw, 0.0f, pullProgress * 4.5f, 1.0f)

            arrow.isCritical = true

            val powerLevel = EnchantmentHelper.getLevel(Enchantments.POWER, stack)
            if (powerLevel > 0) {
                arrow.damage = (arrow.damage + powerLevel * 0.5 + 0.5) * 1.25
            }

            val punchLevel = EnchantmentHelper.getLevel(Enchantments.PUNCH, stack)
            if (punchLevel > 0) {
                arrow.punch = punchLevel + 1
            }

            if (EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0) {
                arrow.setOnFireFor(100)
            }

            stack.damage(1, player) { p -> p.sendToolBreakStatus(player.activeHand) }

            if (isCreativeArrow || player.abilities.creativeMode &&
                (projectileStack.isOf(Items.SPECTRAL_ARROW) || projectileStack.isOf(Items.TIPPED_ARROW))) {
                arrow.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY
            }

            world.spawnEntity(arrow)
        }

        world.playSound(
            null, player.x, player.y, player.z,
            SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0f,
            1.0f / (world.random.nextFloat() * 0.4f + 1.2f) + pullProgress * 0.5f
        )

        if (!isCreativeArrow && !player.abilities.creativeMode) {
            projectileStack.decrement(1)
            if (projectileStack.isEmpty) {
                player.inventory.removeOne(projectileStack)
            }
        }

        player.incrementStat(Stats.USED.getOrCreateStat(this))
    }

    companion object {
        fun getPullProgress(useTicks: Int): Float {
            var progress = useTicks.toFloat() / 10.0f
            progress = (progress * progress + progress * 2.0f) / 3.0f
            return progress.coerceAtMost(1.0f)
        }
    }

    override fun getEnchantability(): Int = 10

    override fun canRepair(stack: ItemStack, ingredient: ItemStack): Boolean {
        return ingredient.isOf(Items.IRON_BLOCK) || super.canRepair(stack, ingredient)
    }
}