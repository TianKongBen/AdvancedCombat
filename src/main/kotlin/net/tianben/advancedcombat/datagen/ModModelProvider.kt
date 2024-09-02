package net.tianben.advancedcombat.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Model
import net.minecraft.data.client.Models
import net.minecraft.util.Identifier
import net.tianben.advancedcombat.AdvancedCombat.Companion.MOD_ID
import net.tianben.advancedcombat.block.ModBlocks
import net.tianben.advancedcombat.item.ModItems
import java.util.Optional


class ModModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ADVANCED_STONE)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_STAR_BLOCK)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_FORTRESS_BLOCK)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.REINFORCED_OBSIDIAN)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        itemModelGenerator.register(ModItems.ADVANCED_WOODEN_SWORD, Models.HANDHELD)
        itemModelGenerator.register(ModItems.ADVANCED_STONE_SWORD, Models.HANDHELD)
        itemModelGenerator.register(ModItems.ADVANCED_IRON_SWORD, Models.HANDHELD)
        itemModelGenerator.register(ModItems.ADVANCED_GOLDEN_SWORD, Models.HANDHELD)
        itemModelGenerator.register(ModItems.ADVANCED_EMERALD_SWORD, Models.HANDHELD)
        itemModelGenerator.register(ModItems.ADVANCED_DIAMOND_SWORD, Models.HANDHELD)
        itemModelGenerator.register(ModItems.NETHER_STAR_SWORD, Models.HANDHELD)
        itemModelGenerator.register(ModItems.ADVANCED_NETHER_STAR_SWORD, Models.HANDHELD)
        itemModelGenerator.register(ModItems.CREATIVE_SWORD, Models.HANDHELD)

        itemModelGenerator.register(ModItems.WOODEN_HELMET, Models.GENERATED)
        itemModelGenerator.register(ModItems.WOODEN_CHESTPLATE, Models.GENERATED)
        itemModelGenerator.register(ModItems.WOODEN_LEGGINGS, Models.GENERATED)
        itemModelGenerator.register(ModItems.WOODEN_BOOTS, Models.GENERATED)

        itemModelGenerator.register(ModItems.STONE_HELMET, Models.GENERATED)
        itemModelGenerator.register(ModItems.STONE_CHESTPLATE, Models.GENERATED)
        itemModelGenerator.register(ModItems.STONE_LEGGINGS, Models.GENERATED)
        itemModelGenerator.register(ModItems.STONE_BOOTS, Models.GENERATED)

        itemModelGenerator.register(ModItems.NETHER_FORTRESS_HELMET, Models.GENERATED)
        itemModelGenerator.register(ModItems.NETHER_FORTRESS_CHESTPLATE, Models.GENERATED)
        itemModelGenerator.register(ModItems.NETHER_FORTRESS_LEGGINGS, Models.GENERATED)
        itemModelGenerator.register(ModItems.NETHER_FORTRESS_BOOTS, Models.GENERATED)

        itemModelGenerator.register(ModItems.OBSIDIAN_HELMET, Models.GENERATED)
        itemModelGenerator.register(ModItems.OBSIDIAN_CHESTPLATE, Models.GENERATED)
        itemModelGenerator.register(ModItems.OBSIDIAN_LEGGINGS, Models.GENERATED)
        itemModelGenerator.register(ModItems.OBSIDIAN_BOOTS, Models.GENERATED)

        itemModelGenerator.register(ModItems.SHARPNESS_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_SHARPNESS_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/sharpness_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.SMITE_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_SMITE_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/smite_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.SPIDER_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_SPIDER_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/spider_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.UNBREAKING_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_UNBREAKING_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/unbreaking_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.MENDING_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(ModItems.PROTECTION_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_PROTECTION_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/protection_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.FIRE_PROTECTION_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_FIRE_PROTECTION_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/fire_protection_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.BLAST_PROTECTION_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_BLAST_PROTECTION_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/blast_protection_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.PROJECTILE_PROTECTION_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_PROJECTILE_PROTECTION_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/projectile_protection_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.FEATHER_FALLING_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_FEATHER_FALLING_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/feather_falling_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.AQUA_AFFINITY_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(ModItems.DEPTH_STRIDER_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(ModItems.EFFICIENCY_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_EFFICIENCY_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/efficiency_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.FORTUNE_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_FORTUNE_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/fortune_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.FROST_WALKER_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_FROST_WALKER_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/frost_walker_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.INFINITY_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(ModItems.LOTS_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_LOTS_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/lots_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.LURE_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_LURE_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/lure_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.POWER_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_POWER_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/power_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.PUNCH_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_PUNCH_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/punch_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.SILK_TOUCH_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(ModItems.KNOCKBACK_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_KNOCKBACK_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/knockback_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.LOOTING_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_LOOTING_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/looting_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.RESPIRATION_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(ModItems.THORNS_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_THORNS_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/thorns_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.FIRE_ASPECT_UPGRADE, Models.GENERATED)
        itemModelGenerator.register(
            ModItems.ELITE_FIRE_ASPECT_UPGRADE,
            Model(Optional.of(Identifier(MOD_ID, "item/fire_aspect_upgrade")), Optional.empty())
        )
        itemModelGenerator.register(ModItems.FLAME_UPGRADE, Models.GENERATED)
    }
}