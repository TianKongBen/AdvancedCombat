package net.tianben.advancedcombat.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.tianben.advancedcombat.AdvancedCombat;
import net.tianben.advancedcombat.enchated.EnchantUpgrade;
import net.tianben.advancedcombat.enchated.EnchantedSwordItem;
import net.tianben.advancedcombat.enchated.SingleEnchantUpgrade;
import net.tianben.advancedcombat.item.bow.AdvancedBowItem;
import net.tianben.advancedcombat.item.shield.AdvancedShieldItem;
import net.tianben.advancedcombat.item.sword.CreativeSwordItem;
import net.tianben.advancedcombat.item.sword.ModToolMaterial;

public class ModItems{
    //注册剑
    public static final Item ADVANCED_WOODEN_SWORD = registerItem("advanced_wooden_sword",
            new SwordItem(ModToolMaterial.ADVANCED_WOODEN_TOOL, 5, -2.4f, new FabricItemSettings()));
    public static final Item ADVANCED_STONE_SWORD = registerItem("advanced_stone_sword",
            new SwordItem(ModToolMaterial.ADVANCED_STONE_TOOL, 7, -2.4f, new FabricItemSettings()));
    public static final Item ADVANCED_IRON_SWORD = registerItem("advanced_iron_sword",
            new SwordItem(ModToolMaterial.ADVANCED_IRON_TOOL, 14, -2.4f, new FabricItemSettings()));
    public static final Item ADVANCED_GOLDEN_SWORD = registerItem("advanced_golden_sword",
            new SwordItem(ModToolMaterial.ADVANCED_GOLDEN_TOOL, 10, -2.4f, new FabricItemSettings()));
    public static final Item ADVANCED_EMERALD_SWORD = registerItem("advanced_emerald_sword",
            new SwordItem(ModToolMaterial.ADVANCED_EMERALD_TOOL, 18, -2.4f, new FabricItemSettings()));
    public static final Item ADVANCED_DIAMOND_SWORD = registerItem("advanced_diamond_sword",
            new SwordItem(ModToolMaterial.ADVANCED_DIAMOND_TOOL, 24, -2.4f, new FabricItemSettings()));
    public static final Item NETHER_STAR_SWORD = registerItem("nether_star_sword",
            new EnchantedSwordItem(ModToolMaterial.NETHER_STAR_TOOL, 30, -2.4f, new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item ADVANCED_NETHER_STAR_SWORD = registerItem("advanced_nether_star_sword",
            new EnchantedSwordItem(ModToolMaterial.ADVANCED_NETHER_STAR_TOOL, 60, -2.4f, new FabricItemSettings().rarity(Rarity.RARE)));
    public static final Item CREATIVE_SWORD = registerItem("creative_sword",
            new CreativeSwordItem());

    //注册附魔升级
    public static final Item SHARPNESS_UPGRADE = registerItem("sharpness_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.SHARPNESS, 1, 5, "enchantment.minecraft.sharpness", false));
    public static final Item ELITE_SHARPNESS_UPGRADE = registerItem("elite_sharpness_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.SHARPNESS, 6, 10, "enchantment.minecraft.sharpness", true));

    public static final Item SMITE_UPGRADE = registerItem("smite_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.SMITE, 1, 5, "enchantment.minecraft.smite", false));
    public static final Item ELITE_SMITE_UPGRADE = registerItem("elite_smite_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.SMITE, 6, 10, "enchantment.minecraft.smite", true));

    public static final Item SPIDER_UPGRADE = registerItem("spider_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.BANE_OF_ARTHROPODS, 1, 5, "enchantment.minecraft.bane_of_arthropods", false));
    public static final Item ELITE_SPIDER_UPGRADE = registerItem("elite_spider_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.BANE_OF_ARTHROPODS, 6, 10, "enchantment.minecraft.bane_of_arthropods", true));

    public static final Item KNOCKBACK_UPGRADE = registerItem("knockback_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.KNOCKBACK, 1, 2, "enchantment.minecraft.knockback", false));
    public static final Item ELITE_KNOCKBACK_UPGRADE = registerItem("elite_knockback_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.KNOCKBACK, 3, 4, "enchantment.minecraft.knockback", true));

    public static final Item FIRE_ASPECT_UPGRADE = registerItem("fire_aspect_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.FIRE_ASPECT, 1, 2, "enchantment.minecraft.fire_aspect", false));
    public static final Item ELITE_FIRE_ASPECT_UPGRADE = registerItem("elite_fire_aspect_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.FIRE_ASPECT, 3, 4, "enchantment.minecraft.fire_aspect", true));

    public static final Item LOOTING_UPGRADE = registerItem("looting_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.LOOTING, 1, 3, "enchantment.minecraft.looting", false));
    public static final Item ELITE_LOOTING_UPGRADE = registerItem("elite_looting_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.LOOTING, 4, 6, "enchantment.minecraft.looting", true));

    public static final Item UNBREAKING_UPGRADE = registerItem("unbreaking_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.UNBREAKING, 1, 3, "enchantment.minecraft.unbreaking", false));
    public static final Item ELITE_UNBREAKING_UPGRADE = registerItem("elite_unbreaking_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.UNBREAKING, 4, 6, "enchantment.minecraft.unbreaking", true));

    public static final Item MENDING_UPGRADE = registerItem("mending_upgrade",
            new SingleEnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.MENDING, 1, 1, "enchantment.minecraft.mending", false));

    public static final Item PROTECTION_UPGRADE = registerItem("protection_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.PROTECTION, 1, 5, "enchantment.minecraft.protection", false));
    public static final Item ELITE_PROTECTION_UPGRADE = registerItem("elite_protection_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.PROTECTION, 6, 10, "enchantment.minecraft.protection", true));

    public static final Item FIRE_PROTECTION_UPGRADE = registerItem("fire_protection_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.FIRE_PROTECTION, 1, 5, "enchantment.minecraft.fire_protection", false));
    public static final Item ELITE_FIRE_PROTECTION_UPGRADE = registerItem("elite_fire_protection_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.FIRE_PROTECTION, 6, 10, "enchantment.minecraft.fire_protection", true));

    public static final Item BLAST_PROTECTION_UPGRADE = registerItem("blast_protection_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.BLAST_PROTECTION, 1, 5, "enchantment.minecraft.blast_protection", false));
    public static final Item ELITE_BLAST_PROTECTION_UPGRADE = registerItem("elite_blast_protection_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.BLAST_PROTECTION, 6, 10, "enchantment.minecraft.blast_protection", true));

    public static final Item PROJECTILE_PROTECTION_UPGRADE = registerItem("projectile_protection_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.PROJECTILE_PROTECTION, 1, 5, "enchantment.minecraft.projectile_protection", false));
    public static final Item ELITE_PROJECTILE_PROTECTION_UPGRADE = registerItem("elite_projectile_protection_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.PROJECTILE_PROTECTION, 6, 10, "enchantment.minecraft.projectile_protection", true));

    public static final Item FEATHER_FALLING_UPGRADE = registerItem("feather_falling_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.FEATHER_FALLING, 1, 5, "enchantment.minecraft.feather_falling", false));
    public static final Item ELITE_FEATHER_FALLING_UPGRADE = registerItem("elite_feather_falling_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.FEATHER_FALLING, 6, 10, "enchantment.minecraft.feather_falling", true));

    public static final Item RESPIRATION_UPGRADE = registerItem("respiration_upgrade",
            new SingleEnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.RESPIRATION, 1, 3, "enchantment.minecraft.respiration", false));

    public static final Item AQUA_AFFINITY_UPGRADE = registerItem("aqua_affinity_upgrade",
            new SingleEnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.AQUA_AFFINITY, 1, 1, "enchantment.minecraft.aqua_affinity", false));

    public static final Item THORNS_UPGRADE = registerItem("thorns_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.THORNS, 1, 3, "enchantment.minecraft.thorns", false));
    public static final Item ELITE_THORNS_UPGRADE = registerItem("elite_thorns_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.THORNS, 4, 6, "enchantment.minecraft.thorns", true));

    public static final Item DEPTH_STRIDER_UPGRADE = registerItem("depth_strider_upgrade",
            new SingleEnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.DEPTH_STRIDER, 1, 3, "enchantment.minecraft.depth_strider", false));

    public static final Item FROST_WALKER_UPGRADE = registerItem("frost_walker_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.FROST_WALKER, 1, 2, "enchantment.minecraft.frost_walker", false));
    public static final Item ELITE_FROST_WALKER_UPGRADE = registerItem("elite_frost_walker_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.FROST_WALKER, 3, 4, "enchantment.minecraft.frost_walker", true));

    public static final Item EFFICIENCY_UPGRADE = registerItem("efficiency_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.EFFICIENCY, 1, 5, "enchantment.minecraft.efficiency", false));
    public static final Item ELITE_EFFICIENCY_UPGRADE = registerItem("elite_efficiency_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.EFFICIENCY, 6, 10, "enchantment.minecraft.efficiency", true));

    public static final Item SILK_TOUCH_UPGRADE = registerItem("silk_touch_upgrade",
            new SingleEnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.SILK_TOUCH, 1, 1, "enchantment.minecraft.silk_touch", false));

    public static final Item FORTUNE_UPGRADE = registerItem("fortune_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.FORTUNE, 1, 3, "enchantment.minecraft.fortune", false));
    public static final Item ELITE_FORTUNE_UPGRADE = registerItem("elite_fortune_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.FORTUNE, 4, 6, "enchantment.minecraft.fortune", true));

    public static final Item POWER_UPGRADE = registerItem("power_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.POWER, 1, 5, "enchantment.minecraft.power", false));
    public static final Item ELITE_POWER_UPGRADE = registerItem("elite_power_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.POWER, 6, 10, "enchantment.minecraft.power", true));

    public static final Item PUNCH_UPGRADE = registerItem("punch_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.PUNCH, 1, 2, "enchantment.minecraft.punch", false));
    public static final Item ELITE_PUNCH_UPGRADE = registerItem("elite_punch_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.PUNCH, 3, 4, "enchantment.minecraft.punch", true));

    public static final Item FLAME_UPGRADE = registerItem("flame_upgrade",
            new SingleEnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.FLAME, 1, 3, "enchantment.minecraft.flame", false));

    public static final Item INFINITY_UPGRADE = registerItem("infinity_upgrade",
            new SingleEnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.INFINITY, 1, 1, "enchantment.minecraft.infinity", false));

    public static final Item LOTS_UPGRADE = registerItem("lots_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.LUCK_OF_THE_SEA, 1, 3, "enchantment.minecraft.luck_of_the_sea", false));
    public static final Item ELITE_LOTS_UPGRADE = registerItem("elite_lots_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.LUCK_OF_THE_SEA, 4, 6, "enchantment.minecraft.luck_of_the_sea", true));

    public static final Item LURE_UPGRADE = registerItem("lure_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.LURE, 1, 3, "enchantment.minecraft.lure", false));
    public static final Item ELITE_LURE_UPGRADE = registerItem("elite_lure_upgrade",
            new EnchantUpgrade(new Item.Settings().maxCount(64), Enchantments.LURE, 4, 6, "enchantment.minecraft.lure", true));

    //注册弓
    public static final Item ADVANCED_BOW = registerItem("advanced_bow", new AdvancedBowItem());

    //注册盾
    public static final Item ADVANCED_SHIELD = registerItem("advanced_shield", new AdvancedShieldItem());

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AdvancedCombat.MOD_ID, name), item);
    }
    public static void registerModItems() {
        AdvancedCombat.LOGGER.info("Registering Mod Items for " + AdvancedCombat.MOD_ID);

    }
}
