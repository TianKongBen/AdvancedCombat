package net.tianben.advancedcombat.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.tianben.advancedcombat.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.ADVANCED_WOODEN_SWORD)
                .add(ModItems.ADVANCED_STONE_SWORD)
                .add(ModItems.ADVANCED_IRON_SWORD)
                .add(ModItems.ADVANCED_GOLDEN_SWORD)
                .add(ModItems.ADVANCED_EMERALD_SWORD)
                .add(ModItems.ADVANCED_DIAMOND_SWORD)
                .add(ModItems.NETHER_STAR_SWORD)
                .add(ModItems.ADVANCED_NETHER_STAR_SWORD);
    }
}
