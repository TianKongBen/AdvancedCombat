package net.tianben.advancedcombat.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.tianben.advancedcombat.block.ModBlocks;
import net.tianben.advancedcombat.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ADVANCED_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_STAR_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_FORTRESS_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_OBSIDIAN);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ADVANCED_WOODEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADVANCED_STONE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADVANCED_IRON_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADVANCED_GOLDEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADVANCED_EMERALD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADVANCED_DIAMOND_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHER_STAR_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ADVANCED_NETHER_STAR_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CREATIVE_SWORD, Models.HANDHELD);

        itemModelGenerator.register(ModItems.SHARPNESS_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SMITE_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPIDER_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNBREAKING_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MENDING_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PROTECTION_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_PROTECTION_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLAST_PROTECTION_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PROJECTILE_PROTECTION_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FEATHER_FALLING_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AQUA_AFFINITY_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEPTH_STRIDER_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EFFICIENCY_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FORTUNE_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROST_WALKER_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.INFINITY_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LOTS_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LURE_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.POWER_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PUNCH_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILK_TOUCH_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.KNOCKBACK_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LOOTING_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RESPIRATION_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.THORNS_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_ASPECT_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLAME_UPGRADE, Models.GENERATED);
    }
}
