package net.tianben.advancedcombat.item.material

import net.minecraft.item.Items
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.tag.ItemTags
import net.tianben.advancedcombat.block.ModBlocks

enum class ModToolMaterial(
    private val miningLevel: Int,
    private val itemDurability: Int,
    private val miningSpeed: Float,
    private val attackDamage: Float,
    private val enchantability: Int,
    private val repairIngredient: () -> Ingredient
) : ToolMaterial {
    ADVANCED_WOOD(1, 236, 8.0f, -0.25f, 8, { Ingredient.fromTag(ItemTags.LOGS) }),
    ADVANCED_STONE(2, 524, 12.0f, -1.0f, 3, { Ingredient.ofItems(ModBlocks.ADVANCED_STONE) }),
    ADVANCED_IRON(3, 2250, 18.0f, -1.0f, 7, { Ingredient.ofItems(Items.IRON_BLOCK) }),
    ADVANCED_GOLD(2, 1561, 8.0f, -1.0f, 15, { Ingredient.ofItems(Items.GOLD_BLOCK) }),
    ADVANCED_EMERALD(4, 3122, 12.0f, -1.0f, 22, { Ingredient.ofItems(Items.EMERALD_BLOCK) }),
    ADVANCED_DIAMOND(4, 8192, 24.0f, -1.0f, 5, { Ingredient.ofItems(Items.DIAMOND_BLOCK) }),
    NETHER_STAR(4, 9366, 20.0f, -1.0f, 1, { Ingredient.ofItems(Items.NETHER_STAR) }),
    ADVANCED_NETHER_STAR(5, 16384, 30.0f, -1.0f, 0, { Ingredient.ofItems(ModBlocks.NETHER_STAR_BLOCK) }),
    CREATIVE(1000, 1, 0f, 0f, 0, { Ingredient.EMPTY });

    override fun getDurability(): Int = itemDurability

    override fun getMiningSpeedMultiplier(): Float = miningSpeed

    override fun getAttackDamage(): Float = attackDamage

    override fun getMiningLevel(): Int = miningLevel

    override fun getEnchantability(): Int = enchantability

    override fun getRepairIngredient(): Ingredient = repairIngredient()
}