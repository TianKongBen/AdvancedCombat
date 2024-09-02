package net.tianben.advancedcombat.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.enchantment.Enchantments
import net.minecraft.item.ArmorItem
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.item.SwordItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity
import net.tianben.advancedcombat.AdvancedCombat
import net.tianben.advancedcombat.block.ModBlocks
import net.tianben.advancedcombat.enchanted.EnchantUpgrade
import net.tianben.advancedcombat.enchanted.EnchantedSwordItem
import net.tianben.advancedcombat.enchanted.SingleEnchantUpgrade
import net.tianben.advancedcombat.item.armor.NetherArmorItem
import net.tianben.advancedcombat.item.armor.ObsidianArmorItem
import net.tianben.advancedcombat.item.armor.StoneArmorItem
import net.tianben.advancedcombat.item.armor.WoodArmorItem
import net.tianben.advancedcombat.item.bow.AdvancedBowItem
import net.tianben.advancedcombat.item.material.ModArmorMaterials
import net.tianben.advancedcombat.item.material.ModToolMaterial
import net.tianben.advancedcombat.item.shield.AdvancedShieldItem
import net.tianben.advancedcombat.item.sword.CreativeSwordItem

object ModItems {
    val ADVANCED_STONE: Item? = Items.register(ModBlocks.ADVANCED_STONE)
    val NETHER_STAR_BLOCK: Item? = Items.register(ModBlocks.NETHER_STAR_BLOCK)
    val NETHER_FORTRESS_BLOCK: Item? = Items.register(ModBlocks.NETHER_FORTRESS_BLOCK)
    val REINFORCED_OBSIDIAN: Item? = Items.register(ModBlocks.REINFORCED_OBSIDIAN)
    val TRACKING_DISPENSER: Item? = Items.register(ModBlocks.TRACKING_DISPENSER)

    val ADVANCED_WOODEN_SWORD: Item = registerItem(
        "advanced_wooden_sword",
        SwordItem(ModToolMaterial.ADVANCED_WOOD, 5, -2.4f, FabricItemSettings())
    )
    val ADVANCED_STONE_SWORD: Item = registerItem(
        "advanced_stone_sword",
        SwordItem(ModToolMaterial.ADVANCED_STONE, 7, -2.4f, FabricItemSettings())
    )
    val ADVANCED_IRON_SWORD: Item = registerItem(
        "advanced_iron_sword",
        SwordItem(ModToolMaterial.ADVANCED_IRON, 14, -2.4f, FabricItemSettings())
    )
    val ADVANCED_GOLDEN_SWORD: Item = registerItem(
        "advanced_golden_sword",
        SwordItem(ModToolMaterial.ADVANCED_GOLD, 10, -2.4f, FabricItemSettings())
    )
    val ADVANCED_EMERALD_SWORD: Item = registerItem(
        "advanced_emerald_sword",
        SwordItem(ModToolMaterial.ADVANCED_EMERALD, 18, -2.4f, FabricItemSettings())
    )
    val ADVANCED_DIAMOND_SWORD: Item = registerItem(
        "advanced_diamond_sword",
        SwordItem(ModToolMaterial.ADVANCED_DIAMOND, 24, -2.4f, FabricItemSettings())
    )
    val NETHER_STAR_SWORD: Item = registerItem(
        "nether_star_sword",
        EnchantedSwordItem(ModToolMaterial.NETHER_STAR, 30, -2.4f, FabricItemSettings().rarity(Rarity.RARE))
    )
    val ADVANCED_NETHER_STAR_SWORD: Item = registerItem(
        "advanced_nether_star_sword",
        EnchantedSwordItem(ModToolMaterial.ADVANCED_NETHER_STAR, 60, -2.4f, FabricItemSettings().rarity(Rarity.RARE))
    )

    val CREATIVE_SWORD: Item = registerItem(
        "creative_sword",
        CreativeSwordItem(ModToolMaterial.CREATIVE, 3, -2.4f, FabricItemSettings())
    )

    @JvmField
    val ADVANCED_BOW: Item = registerItem("advanced_bow", AdvancedBowItem())

    @JvmField
    val ADVANCED_SHIELD: Item = registerItem("advanced_shield", AdvancedShieldItem())

    val WOODEN_HELMET: Item = registerItem(
        "wooden_helmet",
        WoodArmorItem(ModArmorMaterials.WOODEN, ArmorItem.Type.HELMET, FabricItemSettings())
    )
    val WOODEN_CHESTPLATE: Item = registerItem(
        "wooden_chestplate",
        WoodArmorItem(ModArmorMaterials.WOODEN, ArmorItem.Type.CHESTPLATE, FabricItemSettings())
    )
    val WOODEN_LEGGINGS: Item = registerItem(
        "wooden_leggings",
        WoodArmorItem(ModArmorMaterials.WOODEN, ArmorItem.Type.LEGGINGS, FabricItemSettings())
    )
    val WOODEN_BOOTS: Item = registerItem(
        "wooden_boots",
        WoodArmorItem(ModArmorMaterials.WOODEN, ArmorItem.Type.BOOTS, FabricItemSettings())
    )

    val STONE_HELMET: Item = registerItem(
        "stone_helmet",
        StoneArmorItem(ModArmorMaterials.STONE, ArmorItem.Type.HELMET, FabricItemSettings())
    )
    val STONE_CHESTPLATE: Item = registerItem(
        "stone_chestplate",
        StoneArmorItem(ModArmorMaterials.STONE, ArmorItem.Type.CHESTPLATE, FabricItemSettings())
    )
    val STONE_LEGGINGS: Item = registerItem(
        "stone_leggings",
        StoneArmorItem(ModArmorMaterials.STONE, ArmorItem.Type.LEGGINGS, FabricItemSettings())
    )
    val STONE_BOOTS: Item = registerItem(
        "stone_boots",
        StoneArmorItem(ModArmorMaterials.STONE, ArmorItem.Type.BOOTS, FabricItemSettings())
    )

    val NETHER_FORTRESS_HELMET: Item = registerItem(
        "nether_fortress_helmet",
        NetherArmorItem(ModArmorMaterials.NETHER_FORTRESS, ArmorItem.Type.HELMET, FabricItemSettings())
    )
    val NETHER_FORTRESS_CHESTPLATE: Item = registerItem(
        "nether_fortress_chestplate",
        NetherArmorItem(ModArmorMaterials.NETHER_FORTRESS, ArmorItem.Type.CHESTPLATE, FabricItemSettings())
    )
    val NETHER_FORTRESS_LEGGINGS: Item = registerItem(
        "nether_fortress_leggings",
        NetherArmorItem(ModArmorMaterials.NETHER_FORTRESS, ArmorItem.Type.LEGGINGS, FabricItemSettings())
    )
    val NETHER_FORTRESS_BOOTS: Item = registerItem(
        "nether_fortress_boots",
        NetherArmorItem(ModArmorMaterials.NETHER_FORTRESS, ArmorItem.Type.BOOTS, FabricItemSettings())
    )

    val OBSIDIAN_HELMET: Item = registerItem(
        "obsidian_helmet",
        ObsidianArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.HELMET, FabricItemSettings())
    )
    val OBSIDIAN_CHESTPLATE: Item = registerItem(
        "obsidian_chestplate",
        ObsidianArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.CHESTPLATE, FabricItemSettings())
    )
    val OBSIDIAN_LEGGINGS: Item = registerItem(
        "obsidian_leggings",
        ObsidianArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.LEGGINGS, FabricItemSettings())
    )
    val OBSIDIAN_BOOTS: Item = registerItem(
        "obsidian_boots",
        ObsidianArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.BOOTS, FabricItemSettings())
    )

    val SHARPNESS_UPGRADE: Item = registerItem("sharpness_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.SHARPNESS,
            1, 5, "enchantment.minecraft.sharpness", false))
    
    val ELITE_SHARPNESS_UPGRADE: Item = registerItem("elite_sharpness_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.SHARPNESS,
            6, 10, "enchantment.minecraft.sharpness", true))

    val SMITE_UPGRADE: Item = registerItem("smite_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.SMITE,
            1, 5, "enchantment.minecraft.smite", false))
    
    val ELITE_SMITE_UPGRADE: Item = registerItem("elite_smite_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.SMITE,
            6, 10, "enchantment.minecraft.smite", true))

    val SPIDER_UPGRADE: Item = registerItem("spider_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.BANE_OF_ARTHROPODS,
            1, 5, "enchantment.minecraft.bane_of_arthropods", false))
    
    val ELITE_SPIDER_UPGRADE: Item = registerItem("elite_spider_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.BANE_OF_ARTHROPODS,
            6, 10, "enchantment.minecraft.bane_of_arthropods", true))

    val KNOCKBACK_UPGRADE: Item = registerItem("knockback_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.KNOCKBACK,
            1, 2, "enchantment.minecraft.knockback", false))
    
    val ELITE_KNOCKBACK_UPGRADE: Item = registerItem("elite_knockback_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.KNOCKBACK,
            3, 4, "enchantment.minecraft.knockback", true))

    val FIRE_ASPECT_UPGRADE: Item = registerItem("fire_aspect_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.FIRE_ASPECT,
            1, 2, "enchantment.minecraft.fire_aspect", false))
    
    val ELITE_FIRE_ASPECT_UPGRADE: Item = registerItem("elite_fire_aspect_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.FIRE_ASPECT,
            3, 4, "enchantment.minecraft.fire_aspect", true))

    val LOOTING_UPGRADE: Item = registerItem("looting_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.LOOTING,
            1, 3, "enchantment.minecraft.looting", false))
    
    val ELITE_LOOTING_UPGRADE: Item = registerItem("elite_looting_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.LOOTING,
            4, 6, "enchantment.minecraft.looting", true))

    val UNBREAKING_UPGRADE: Item = registerItem("unbreaking_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.UNBREAKING,
            1, 3, "enchantment.minecraft.unbreaking", false))
    
    val ELITE_UNBREAKING_UPGRADE: Item = registerItem("elite_unbreaking_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.UNBREAKING,
            4, 6, "enchantment.minecraft.unbreaking", true))

    val MENDING_UPGRADE: Item = registerItem("mending_upgrade",
        SingleEnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.MENDING,
            1, 1, "enchantment.minecraft.mending", false))

    val PROTECTION_UPGRADE: Item = registerItem("protection_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.PROTECTION,
            1, 4, "enchantment.minecraft.protection", false))
    
    val ELITE_PROTECTION_UPGRADE: Item = registerItem("elite_protection_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.PROTECTION,
            5, 8, "enchantment.minecraft.protection", true))

    val FIRE_PROTECTION_UPGRADE: Item = registerItem("fire_protection_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.FIRE_PROTECTION,
            1, 4, "enchantment.minecraft.fire_protection", false))
    
    val ELITE_FIRE_PROTECTION_UPGRADE: Item = registerItem("elite_fire_protection_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.FIRE_PROTECTION,
            5, 8, "enchantment.minecraft.fire_protection", true))

    val BLAST_PROTECTION_UPGRADE: Item = registerItem("blast_protection_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.BLAST_PROTECTION,
            1, 4, "enchantment.minecraft.blast_protection", false))
    
    val ELITE_BLAST_PROTECTION_UPGRADE: Item = registerItem("elite_blast_protection_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.BLAST_PROTECTION,
            5, 8, "enchantment.minecraft.blast_protection", true))

    val PROJECTILE_PROTECTION_UPGRADE: Item = registerItem("projectile_protection_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.PROJECTILE_PROTECTION,
            1, 4, "enchantment.minecraft.projectile_protection", false))
    
    val ELITE_PROJECTILE_PROTECTION_UPGRADE: Item = registerItem("elite_projectile_protection_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.PROJECTILE_PROTECTION,
            5, 8, "enchantment.minecraft.projectile_protection", true))

    val FEATHER_FALLING_UPGRADE: Item = registerItem("feather_falling_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.FEATHER_FALLING,
            1, 4, "enchantment.minecraft.feather_falling", false))
    
    val ELITE_FEATHER_FALLING_UPGRADE: Item = registerItem("elite_feather_falling_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.FEATHER_FALLING,
            5, 8, "enchantment.minecraft.feather_falling", true))

    val RESPIRATION_UPGRADE: Item = registerItem("respiration_upgrade",
        SingleEnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.RESPIRATION,
            1, 3, "enchantment.minecraft.respiration", false))

    val AQUA_AFFINITY_UPGRADE: Item = registerItem("aqua_affinity_upgrade",
        SingleEnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.AQUA_AFFINITY,
            1, 1, "enchantment.minecraft.aqua_affinity", false))

    val THORNS_UPGRADE: Item = registerItem("thorns_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.THORNS,
            1, 3, "enchantment.minecraft.thorns", false))
    
    val ELITE_THORNS_UPGRADE: Item = registerItem("elite_thorns_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.THORNS,
            4, 6, "enchantment.minecraft.thorns", true))

    val DEPTH_STRIDER_UPGRADE: Item = registerItem("depth_strider_upgrade",
        SingleEnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.DEPTH_STRIDER,
            1, 3, "enchantment.minecraft.depth_strider", false))

    val FROST_WALKER_UPGRADE: Item = registerItem("frost_walker_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.FROST_WALKER,
            1, 2, "enchantment.minecraft.frost_walker", false))
    
    val ELITE_FROST_WALKER_UPGRADE: Item = registerItem("elite_frost_walker_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.FROST_WALKER,
            3, 4, "enchantment.minecraft.frost_walker", true))

    val EFFICIENCY_UPGRADE: Item = registerItem("efficiency_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.EFFICIENCY,
            1, 5, "enchantment.minecraft.efficiency", false))
    
    val ELITE_EFFICIENCY_UPGRADE: Item = registerItem("elite_efficiency_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.EFFICIENCY,
            6, 10, "enchantment.minecraft.efficiency", true))

    val SILK_TOUCH_UPGRADE: Item = registerItem("silk_touch_upgrade",
        SingleEnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.SILK_TOUCH,
            1, 1, "enchantment.minecraft.silk_touch", false))

    val FORTUNE_UPGRADE: Item = registerItem("fortune_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.FORTUNE,
            1, 3, "enchantment.minecraft.fortune", false))
    
    val ELITE_FORTUNE_UPGRADE: Item = registerItem("elite_fortune_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.FORTUNE,
            4, 6, "enchantment.minecraft.fortune", true))

    val POWER_UPGRADE: Item = registerItem("power_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.POWER,
            1, 5, "enchantment.minecraft.power", false))
    
    val ELITE_POWER_UPGRADE: Item = registerItem("elite_power_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.POWER,
            6, 10, "enchantment.minecraft.power", true))

    val PUNCH_UPGRADE: Item = registerItem("punch_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.PUNCH,
            1, 2, "enchantment.minecraft.punch", false))
    
    val ELITE_PUNCH_UPGRADE: Item = registerItem("elite_punch_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.PUNCH,
            3, 4, "enchantment.minecraft.punch", true))

    val FLAME_UPGRADE: Item = registerItem("flame_upgrade",
        SingleEnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.FLAME,
            1, 1, "enchantment.minecraft.flame", false))

    val INFINITY_UPGRADE: Item = registerItem("infinity_upgrade",
        SingleEnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.INFINITY,
            1, 1, "enchantment.minecraft.infinity", false))

    val LOTS_UPGRADE: Item = registerItem("lots_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.LUCK_OF_THE_SEA,
            1, 3, "enchantment.minecraft.luck_of_the_sea", false))
    
    val ELITE_LOTS_UPGRADE: Item = registerItem("elite_lots_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.LUCK_OF_THE_SEA,
            4, 6, "enchantment.minecraft.luck_of_the_sea", true))

    val LURE_UPGRADE: Item = registerItem("lure_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.LURE,
            1, 3, "enchantment.minecraft.lure", false))
    
    val ELITE_LURE_UPGRADE: Item = registerItem("elite_lure_upgrade",
        EnchantUpgrade(FabricItemSettings().maxCount(64), Enchantments.LURE,
            4, 6, "enchantment.minecraft.lure", true))

    fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier(AdvancedCombat.MOD_ID, name), item)
    }

    fun getAllEnchantUpgrades(): List<Item> {
        return listOf(
            SHARPNESS_UPGRADE, ELITE_SHARPNESS_UPGRADE,
            SMITE_UPGRADE, ELITE_SMITE_UPGRADE,
            SPIDER_UPGRADE, ELITE_SPIDER_UPGRADE,
            KNOCKBACK_UPGRADE, ELITE_KNOCKBACK_UPGRADE,
            FIRE_ASPECT_UPGRADE, ELITE_FIRE_ASPECT_UPGRADE,
            LOOTING_UPGRADE, ELITE_LOOTING_UPGRADE,
            UNBREAKING_UPGRADE, ELITE_UNBREAKING_UPGRADE,
            MENDING_UPGRADE,
            PROTECTION_UPGRADE, ELITE_PROTECTION_UPGRADE,
            FIRE_PROTECTION_UPGRADE, ELITE_FIRE_PROTECTION_UPGRADE,
            BLAST_PROTECTION_UPGRADE, ELITE_BLAST_PROTECTION_UPGRADE,
            PROJECTILE_PROTECTION_UPGRADE, ELITE_PROJECTILE_PROTECTION_UPGRADE,
            FEATHER_FALLING_UPGRADE, ELITE_FEATHER_FALLING_UPGRADE,
            RESPIRATION_UPGRADE,
            AQUA_AFFINITY_UPGRADE,
            THORNS_UPGRADE, ELITE_THORNS_UPGRADE,
            DEPTH_STRIDER_UPGRADE,
            FROST_WALKER_UPGRADE, ELITE_FROST_WALKER_UPGRADE,
            EFFICIENCY_UPGRADE, ELITE_EFFICIENCY_UPGRADE,
            SILK_TOUCH_UPGRADE,
            FORTUNE_UPGRADE, ELITE_FORTUNE_UPGRADE,
            POWER_UPGRADE, ELITE_POWER_UPGRADE,
            PUNCH_UPGRADE, ELITE_PUNCH_UPGRADE,
            FLAME_UPGRADE,
            INFINITY_UPGRADE,
            LOTS_UPGRADE, ELITE_LOTS_UPGRADE,
            LURE_UPGRADE, ELITE_LURE_UPGRADE
        )
    }

    fun registerModItems() {
        AdvancedCombat.LOGGER?.info("Registering Mod Items for " + AdvancedCombat.MOD_ID)
    }
}