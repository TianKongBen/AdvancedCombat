package net.tianben.advancedcombat.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.ItemTags
import net.tianben.advancedcombat.item.ModItems
import java.util.concurrent.CompletableFuture

class ModItemTagProvider(
    output: FabricDataOutput,
    completableFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricTagProvider.ItemTagProvider(output, completableFuture) {

    override fun configure(arg: RegistryWrapper.WrapperLookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
            .add(ModItems.ADVANCED_WOODEN_SWORD)
            .add(ModItems.ADVANCED_STONE_SWORD)
            .add(ModItems.ADVANCED_IRON_SWORD)
            .add(ModItems.ADVANCED_GOLDEN_SWORD)
            .add(ModItems.ADVANCED_EMERALD_SWORD)
            .add(ModItems.ADVANCED_DIAMOND_SWORD)
            .add(ModItems.NETHER_STAR_SWORD)
            .add(ModItems.ADVANCED_NETHER_STAR_SWORD)
            .add(ModItems.CREATIVE_SWORD)
    }
}