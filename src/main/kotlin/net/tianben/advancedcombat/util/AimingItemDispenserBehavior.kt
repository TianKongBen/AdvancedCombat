package net.tianben.advancedcombat.util

import net.minecraft.block.DispenserBlock
import net.minecraft.block.dispenser.ItemDispenserBehavior
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.ProjectileEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPointer
import net.minecraft.util.math.Position
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World

abstract class AimingItemDispenserBehavior(private val target: LivingEntity?) : ItemDispenserBehavior() {

    fun dispenseAiming(pointer: BlockPointer, stack: ItemStack): ItemStack {
        return if (target != null && target.isAlive) {
            aimAtTarget(pointer, stack)
        } else {
            super.dispense(pointer, stack)
        }
    }

    protected open fun aimAtTarget(pointer: BlockPointer, stack: ItemStack): ItemStack {
        val world = pointer.world
        val position = DispenserBlock.getOutputLocation(pointer)

        val targetPos = target!!.pos.add(0.0, target.standingEyeHeight.toDouble() * 0.8, 0.0)
        val dispenserPos = Vec3d(position.x, position.y, position.z)
        val direction = targetPos.subtract(dispenserPos).normalize()

        val projectile = createAimingProjectile(world, position, stack, direction)

        projectile.noClip = true

        val offsetDistance = 0.3
        projectile.setPosition(
            position.x + direction.x * offsetDistance,
            position.y + direction.y * offsetDistance,
            position.z + direction.z * offsetDistance
        )

        world.spawnEntity(projectile)
        stack.decrement(1)

        playSound(pointer)

        return stack
    }

    abstract fun createAimingProjectile(world: World, position: Position, stack: ItemStack, direction: Vec3d): ProjectileEntity

    override fun playSound(pointer: BlockPointer) {
        pointer.world.syncWorldEvent(1000, pointer.pos, 0)
    }
}