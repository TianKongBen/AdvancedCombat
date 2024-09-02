package net.tianben.advancedcombat.util

import net.minecraft.block.DispenserBlock
import net.minecraft.block.dispenser.ProjectileDispenserBehavior
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPointer
import net.minecraft.util.math.Direction
import net.minecraft.util.math.Position
import net.minecraft.util.math.Vec3d

abstract class AimingProjectileDispenserBehavior(private val target: LivingEntity?) : ProjectileDispenserBehavior() {

    fun dispenseAiming(pointer: BlockPointer, stack: ItemStack): ItemStack {
        return if (target != null && target.isAlive) {
            aimAtTarget(pointer, stack)
        } else {
            super.dispense(pointer, stack)
        }
    }

    private fun aimAtTarget(pointer: BlockPointer, stack: ItemStack): ItemStack {
        val world = pointer.world

        val blockPos = pointer.pos
        val facing = pointer.blockState.get(DispenserBlock.FACING)

        val position = object : Position {
            override fun getX(): Double = blockPos.x + 0.5
            override fun getY(): Double = blockPos.y + 0.5
            override fun getZ(): Double = blockPos.z + 0.5
        }

        if (target == null || !target.isAlive) {
            return super.dispense(pointer, stack)
        }

        val targetPos = target.pos.add(0.0, target.standingEyeHeight * 0.8, 0.0)
        val dispenserPos = Vec3d(position.x, position.y, position.z)
        val direction = targetPos.subtract(dispenserPos)

        if (direction.lengthSquared() < 0.001) {
            return super.dispense(pointer, stack)
        }

        val normalizedDir = direction.normalize()

        val projectile = createProjectile(world, position, stack)

        projectile.noClip = true

        val offsetDistance = 0.3
        val startX = position.x + normalizedDir.x * offsetDistance
        val startY = position.y + normalizedDir.y * offsetDistance
        val startZ = position.z + normalizedDir.z * offsetDistance
        projectile.setPosition(startX, startY, startZ)

        val speed = getForce()
        projectile.setVelocity(
            normalizedDir.x * speed,
            normalizedDir.y * speed,
            normalizedDir.z * speed,
            1.0f,
            0.0f
        )

        world.spawnEntity(projectile)
        stack.decrement(1)

        playSound(pointer)
        spawnParticles(pointer, facing)

        return stack
    }

    override fun playSound(pointer: BlockPointer) {
        pointer.world.syncWorldEvent(1000, pointer.pos, 0)
    }

    override fun spawnParticles(pointer: BlockPointer, side: Direction) {
        pointer.world.syncWorldEvent(2000, pointer.pos, side.id)
    }
}