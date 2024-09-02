package net.tianben.advancedcombat.item.group;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tianben.advancedcombat.AdvancedCombat;
import net.tianben.advancedcombat.block.ModBlocks;
import net.tianben.advancedcombat.item.ModItems;

public class ModItemGroups {
    public static final ItemGroup ADVANCEDCOMBAT_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(AdvancedCombat.MOD_ID, "advancedcombat"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.advancedcombat"))
                    .icon(() -> new ItemStack(ModItems.SHARPNESS_UPGRADE)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ADVANCED_STONE);
                        entries.add(ModBlocks.NETHER_STAR_BLOCK);
                        entries.add(ModBlocks.NETHER_FORTRESS_BLOCK);
                        entries.add(ModBlocks.REINFORCED_OBSIDIAN);
                        entries.add(ModBlocks.TRACKING_DISPENSER);

                        entries.add(ModItems.ADVANCED_WOODEN_SWORD);
                        entries.add(ModItems.ADVANCED_STONE_SWORD);
                        entries.add(ModItems.ADVANCED_IRON_SWORD);
                        entries.add(ModItems.ADVANCED_GOLDEN_SWORD);
                        entries.add(ModItems.ADVANCED_EMERALD_SWORD);
                        entries.add(ModItems.ADVANCED_DIAMOND_SWORD);
                        entries.add(ModItems.NETHER_STAR_SWORD);
                        entries.add(ModItems.ADVANCED_NETHER_STAR_SWORD);
                        entries.add(ModItems.CREATIVE_SWORD);

                        entries.add(ModItems.SHARPNESS_UPGRADE);
                        entries.add(ModItems.ELITE_SHARPNESS_UPGRADE);

                        entries.add(ModItems.SMITE_UPGRADE);
                        entries.add(ModItems.ELITE_SMITE_UPGRADE);

                        entries.add(ModItems.SPIDER_UPGRADE);
                        entries.add(ModItems.ELITE_SPIDER_UPGRADE);

                        entries.add(ModItems.KNOCKBACK_UPGRADE);
                        entries.add(ModItems.ELITE_KNOCKBACK_UPGRADE);

                        entries.add(ModItems.FIRE_ASPECT_UPGRADE);
                        entries.add(ModItems.ELITE_FIRE_ASPECT_UPGRADE);

                        entries.add(ModItems.LOOTING_UPGRADE);
                        entries.add(ModItems.ELITE_LOOTING_UPGRADE);

                        entries.add(ModItems.UNBREAKING_UPGRADE);
                        entries.add(ModItems.ELITE_UNBREAKING_UPGRADE);

                        entries.add(ModItems.MENDING_UPGRADE);

                        entries.add(ModItems.PROTECTION_UPGRADE);
                        entries.add(ModItems.ELITE_PROTECTION_UPGRADE);

                        entries.add(ModItems.FIRE_PROTECTION_UPGRADE);
                        entries.add(ModItems.ELITE_FIRE_PROTECTION_UPGRADE);

                        entries.add(ModItems.BLAST_PROTECTION_UPGRADE);
                        entries.add(ModItems.ELITE_BLAST_PROTECTION_UPGRADE);

                        entries.add(ModItems.PROJECTILE_PROTECTION_UPGRADE);
                        entries.add(ModItems.ELITE_PROJECTILE_PROTECTION_UPGRADE);

                        entries.add(ModItems.FEATHER_FALLING_UPGRADE);
                        entries.add(ModItems.ELITE_FEATHER_FALLING_UPGRADE);

                        entries.add(ModItems.RESPIRATION_UPGRADE);

                        entries.add(ModItems.AQUA_AFFINITY_UPGRADE);

                        entries.add(ModItems.THORNS_UPGRADE);
                        entries.add(ModItems.ELITE_THORNS_UPGRADE);

                        entries.add(ModItems.DEPTH_STRIDER_UPGRADE);

                        entries.add(ModItems.FROST_WALKER_UPGRADE);
                        entries.add(ModItems.ELITE_FROST_WALKER_UPGRADE);

                        entries.add(ModItems.EFFICIENCY_UPGRADE);
                        entries.add(ModItems.ELITE_EFFICIENCY_UPGRADE);

                        entries.add(ModItems.SILK_TOUCH_UPGRADE);

                        entries.add(ModItems.FORTUNE_UPGRADE);
                        entries.add(ModItems.ELITE_FORTUNE_UPGRADE);

                        entries.add(ModItems.POWER_UPGRADE);
                        entries.add(ModItems.ELITE_POWER_UPGRADE);

                        entries.add(ModItems.PUNCH_UPGRADE);
                        entries.add(ModItems.ELITE_PUNCH_UPGRADE);

                        entries.add(ModItems.FLAME_UPGRADE);

                        entries.add(ModItems.INFINITY_UPGRADE);

                        entries.add(ModItems.LOTS_UPGRADE);
                        entries.add(ModItems.ELITE_LOTS_UPGRADE);

                        entries.add(ModItems.LURE_UPGRADE);
                        entries.add(ModItems.ELITE_LURE_UPGRADE);

                        entries.add(ModItems.ADVANCED_BOW);

                        entries.add(ModItems.ADVANCED_SHIELD);
                    }).build());


    public static void registerItemGroups() {
        AdvancedCombat.LOGGER .info("Registering Item Groups for " + AdvancedCombat.MOD_ID);
    }
}
