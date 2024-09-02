package net.tianben.advancedcombat.block

import net.minecraft.block.BlockState
import net.minecraft.block.DispenserBlock
import net.minecraft.block.dispenser.DispenserBehavior
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.DispenserBlockEntity
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPointerImpl
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Box
import net.minecraft.world.World
import net.minecraft.world.event.GameEvent
import net.tianben.advancedcombat.util.*

class TrackingDispenserBlock(settings: Settings) : DispenserBlock(settings) {

    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        return DispenserBlockEntity(pos, state)
    }

    override fun dispense(world: ServerWorld, pos: BlockPos) {
        val blockEntity = world.getBlockEntity(pos) as? DispenserBlockEntity ?: return
        val blockPointer = BlockPointerImpl(world, pos)
        val slot = blockEntity.chooseNonEmptySlot(world.random)

        if (slot < 0) {
            world.syncWorldEvent(1001, pos, 0)
            world.emitGameEvent(GameEvent.BLOCK_ACTIVATE, pos, GameEvent.Emitter.of(blockEntity.cachedState))
            return
        }

        val stack = blockEntity.getStack(slot)
        if (stack.isEmpty) return

        val target = findTarget(world, pos)

        val behavior = getTrackingBehaviorForItem(stack, target)

        try {
            val result = when (behavior) {
                is AimingProjectileDispenserBehavior -> behavior.dispenseAiming(blockPointer, stack)
                is AimingItemDispenserBehavior -> behavior.dispenseAiming(blockPointer, stack)
                else -> behavior.dispense(blockPointer, stack)
            }
            blockEntity.setStack(slot, result)
        } catch (e: Exception) {
            val defaultBehavior = getBehaviorForItem(stack)
            if (defaultBehavior != DispenserBehavior.NOOP) {
                val result = defaultBehavior.dispense(blockPointer, stack)
                blockEntity.setStack(slot, result)
            }
        }
    }

    private fun findTarget(world: World, pos: BlockPos): LivingEntity? {
        val range = 32

        val searchBox = Box(
            pos.add(-range, -range, -range),
            pos.add(range, range, range)
        )

        return world.getEntitiesByClass(
            LivingEntity::class.java,
            searchBox
        ) { entity ->
            entity.isAlive &&
                    entity.squaredDistanceTo(pos.toCenterPos()) > 9.0 &&
                    !entity.isSpectator &&

                    (entity !is net.minecraft.entity.player.PlayerEntity ||
                            !entity.abilities.creativeMode)
        }.minByOrNull { it.squaredDistanceTo(pos.toCenterPos()) }
    }

    private fun getTrackingBehaviorForItem(stack: ItemStack, target: LivingEntity?): DispenserBehavior {
        val item = stack.item

        return when (item) {
            Items.ARROW,
            Items.TIPPED_ARROW,
            Items.SPECTRAL_ARROW -> AimingArrowDispenserBehavior(target)

            Items.SPLASH_POTION,
            Items.LINGERING_POTION -> AimingPotionDispenserBehavior(target)

            Items.FIRE_CHARGE -> AimingFireballDispenserBehavior(target)

            Items.EGG -> AimingEggDispenserBehavior(target)
            Items.SNOWBALL -> AimingSnowballDispenserBehavior(target)
            Items.EXPERIENCE_BOTTLE -> AimingExperienceBottleDispenserBehavior(target)

            else -> getBehaviorForItem(stack)
        }
    }

    override fun onPlaced(world: World, pos: BlockPos, state: BlockState, placer: LivingEntity?, stack: ItemStack) {
        super.onPlaced(world, pos, state, placer, stack)

        val blockEntity = world.getBlockEntity(pos) as? DispenserBlockEntity ?: return

        if (stack.hasCustomName()) {
            blockEntity.customName = stack.name
        } else if (!blockEntity.hasCustomName()) {
            blockEntity.customName = name
        }
    }
}