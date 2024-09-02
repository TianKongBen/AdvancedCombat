package net.tianben.advancedcombat.util

import net.minecraft.client.item.ModelPredicateProviderRegistry
import net.minecraft.util.Identifier
import net.tianben.advancedcombat.item.ModItems

object ModModelPredicateProvider {

    fun registerModItemModelPredicates() {
        registerShield()
    }

    private fun registerShield() {
        ModelPredicateProviderRegistry.register(
            ModItems.ADVANCED_SHIELD,
            Identifier("blocking")
        ) { stack, _, entity, _ ->
            if (entity != null && entity.isUsingItem && entity.activeItem == stack) 1.0f else 0.0f
        }
    }

    fun registerModModels() {
        registerBow()
    }

    private fun registerBow() {
        ModelPredicateProviderRegistry.register(
            ModItems.ADVANCED_BOW,
            Identifier("pull")
        ) { stack, _, entity, _ ->
            if (entity == null) {
                return@register 0.0f
            }
            if (entity.activeItem != stack) {
                return@register 0.0f
            }
            (stack.maxUseTime - entity.itemUseTimeLeft).toFloat() / 10.0f
        }

        ModelPredicateProviderRegistry.register(
            ModItems.ADVANCED_BOW,
            Identifier("pulling")
        ) { stack, _, entity, _ ->
            if (entity != null && entity.isUsingItem && entity.activeItem == stack) 1.0f else 0.0f
        }
    }
}