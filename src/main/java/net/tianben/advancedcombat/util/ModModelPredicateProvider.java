package net.tianben.advancedcombat.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.tianben.advancedcombat.item.ModItems;

public class ModModelPredicateProvider {
    public static void registerModItemModelPredicates() {
        ModModelPredicateProvider.registerShield();

    }

    private static void registerShield() {
        ModelPredicateProviderRegistry.register(ModItems.ADVANCED_SHIELD, new Identifier("blocking"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem()
                        && entity.getActiveItem() == stack ? 1.0f : 0.0f);
    }

    public static void registerModModels() {
        registerBow();
    }

    private static void registerBow() {
        ModelPredicateProviderRegistry.register(ModItems.ADVANCED_BOW, new Identifier("pull"),
                (stack, world, entity, seed) -> {
                    if (entity == null) {
                        return 0.0f;
                    }
                    if (entity.getActiveItem() != stack) {
                        return 0.0f;
                    }
                    return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 10.0f;
                });

        ModelPredicateProviderRegistry.register(ModItems.ADVANCED_BOW, new Identifier("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem()
                        && entity.getActiveItem() == stack ? 1.0f : 0.0f);
    }
}
