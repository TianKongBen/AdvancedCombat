package net.tianben.advancedcombat.item.sword;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.tianben.advancedcombat.block.ModBlocks;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    ADVANCED_WOODEN_TOOL(1, 236, 8.0f, -0.25f, 8, () -> Ingredient.fromTag(ItemTags.LOGS)),
    ADVANCED_STONE_TOOL(2, 524, 12.0f, -1.0f, 3, () -> Ingredient.ofItems(ModBlocks.ADVANCED_STONE)),
    ADVANCED_IRON_TOOL(3, 2250, 10.0f, -1.0f, 9, () -> Ingredient.ofItems(Items.IRON_BLOCK)),
    ADVANCED_GOLDEN_TOOL(2, 1561, 6.0f, -1.0f, 15, () -> Ingredient.ofItems(Items.GOLD_BLOCK)),
    ADVANCED_EMERALD_TOOL(4, 3122, 12.0f, -1.0f, 22, () -> Ingredient.ofItems(Items.EMERALD_BLOCK)),
    ADVANCED_DIAMOND_TOOL(4, 8192, 24.0f, -1.0f, 5, () -> Ingredient.ofItems(Items.DIAMOND_BLOCK)),
    NETHER_STAR_TOOL(4, 9366, 20.0f, -1.0f, 1, () -> Ingredient.ofItems(Items.NETHER_STAR)),
    ADVANCED_NETHER_STAR_TOOL(5, 16384, 30.0f, -1.0f, 0, () -> Ingredient.ofItems(ModBlocks.NETHER_STAR_BLOCK));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attckDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attckDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
