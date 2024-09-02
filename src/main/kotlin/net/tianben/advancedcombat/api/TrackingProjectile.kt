package net.tianben.advancedcombat.api

import net.minecraft.entity.Entity
import net.minecraft.entity.LivingEntity
import kotlin.math.atan2
import kotlin.math.sqrt

interface TrackingProjectile {
    var target: LivingEntity?

    fun updateTracking() {
        val currentTarget = target ?: return
        if (!currentTarget.isAlive) {
            target = null
            return
        }

        val targetPos = currentTarget.pos
        val currentPos = (this as Entity).pos
        val direction = targetPos.subtract(currentPos).normalize()

        val entity = this as Entity
        val currentVelocity = entity.velocity
        val newVelocity = currentVelocity.add(direction.multiply(0.1))
            .normalize().multiply(currentVelocity.length())
        entity.velocity = newVelocity

        entity.yaw = (atan2(newVelocity.x, newVelocity.z) * 57.2957763671875).toFloat()
        entity.pitch = (atan2(
            newVelocity.y, sqrt(newVelocity.x * newVelocity.x + newVelocity.z * newVelocity.z)
        ) * 57.2957763671875).toFloat()
    }
}