package net.tianben.advancedcombat.util

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.projectile.*
import net.minecraft.entity.projectile.thrown.*
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPointer
import net.minecraft.util.math.Position
import net.minecraft.util.math.Vec3d
import net.minecraft.world.World

class AimingArrowDispenserBehavior(target: LivingEntity?) : AimingProjectileDispenserBehavior(target) {
    override fun createProjectile(world: World, position: Position, stack: ItemStack): PersistentProjectileEntity {
        return ArrowEntity(world, position.x, position.y, position.z).apply {
            pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED
        }
    }

    override fun getForce(): Float = 1.5f
    override fun getVariation(): Float = 0.0f
}

class AimingPotionDispenserBehavior(target: LivingEntity?) : AimingProjectileDispenserBehavior(target) {
    override fun createProjectile(world: World, position: Position, stack: ItemStack): ProjectileEntity {
        return PotionEntity(world, position.x, position.y, position.z).apply {
            setItem(stack.copy())
        }
    }

    override fun getForce(): Float = 0.8f
    override fun getVariation(): Float = 0.0f
}

class AimingFireballDispenserBehavior(target: LivingEntity?) : AimingItemDispenserBehavior(target) {
    override fun createAimingProjectile(world: World, position: Position, stack: ItemStack, direction: Vec3d): ProjectileEntity {
        return SmallFireballEntity(world, position.x, position.y, position.z, direction.x, direction.y, direction.z)
    }

    override fun playSound(pointer: BlockPointer) {
        pointer.world.syncWorldEvent(1018, pointer.pos, 0)
    }
}

class AimingEggDispenserBehavior(target: LivingEntity?) : AimingProjectileDispenserBehavior(target) {
    override fun createProjectile(world: World, position: Position, stack: ItemStack): ProjectileEntity {
        return EggEntity(world, position.x, position.y, position.z)
    }

    override fun getForce(): Float = 1.2f
    override fun getVariation(): Float = 0.0f
}

class AimingSnowballDispenserBehavior(target: LivingEntity?) : AimingProjectileDispenserBehavior(target) {
    override fun createProjectile(world: World, position: Position, stack: ItemStack): ProjectileEntity {
        return SnowballEntity(world, position.x, position.y, position.z)
    }

    override fun getForce(): Float = 1.2f
    override fun getVariation(): Float = 0.0f
}

class AimingExperienceBottleDispenserBehavior(target: LivingEntity?) : AimingProjectileDispenserBehavior(target) {
    override fun createProjectile(world: World, position: Position, stack: ItemStack): ProjectileEntity {
        return ExperienceBottleEntity(world, position.x, position.y, position.z)
    }

    override fun getForce(): Float = 0.7f
    override fun getVariation(): Float = 0.0f
}