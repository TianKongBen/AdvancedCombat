package net.tianben.advancedcombat.item.material

import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.registry.tag.ItemTags
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.util.StringIdentifiable
import net.minecraft.util.Util
import net.tianben.advancedcombat.AdvancedCombat
import net.tianben.advancedcombat.item.ModItems
import java.util.*

enum class ModArmorMaterials(
    private val materialName: String,
    private val durabilityMultiplier: Int,
    private val protectionAmounts: EnumMap<ArmorItem.Type, Int>,
    private val enchantability: Int,
    private val equipSound: SoundEvent,
    private val toughness: Float,
    private val knockbackResistance: Float,
    private val repairIngredientSupplier: () -> Ingredient
) : StringIdentifiable, ArmorMaterial {

    WOODEN(
        "wooden", 6,
        Util.make(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java)) { map ->
            map[ArmorItem.Type.BOOTS] = 1
            map[ArmorItem.Type.LEGGINGS] = 3
            map[ArmorItem.Type.CHESTPLATE] = 4
            map[ArmorItem.Type.HELMET] = 1
        },
        5,
        SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
        0f,
        0f,
        { Ingredient.fromTag(ItemTags.LOGS) }
    ),

    STONE(
        "stone", 11,
        Util.make(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java)) { map ->
            map[ArmorItem.Type.BOOTS] = 2
            map[ArmorItem.Type.LEGGINGS] = 4
            map[ArmorItem.Type.CHESTPLATE] = 5
            map[ArmorItem.Type.HELMET] = 2
        },
        8,
        SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
        0f,
        0f,
        { Ingredient.ofItems(ModItems.ADVANCED_STONE) }
    ),

    NETHER_FORTRESS(
        "nether_fortress", 33,
        Util.make(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java)) { map ->
            map[ArmorItem.Type.BOOTS] = 3
            map[ArmorItem.Type.LEGGINGS] = 5
            map[ArmorItem.Type.CHESTPLATE] = 7
            map[ArmorItem.Type.HELMET] = 3
        },
        8,
        SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
        2.5f,
        0.25f,
        { Ingredient.ofItems(ModItems.NETHER_FORTRESS_BLOCK) }
    ),

    OBSIDIAN(
        "obsidian", 88,
        Util.make(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java)) { map ->
            map[ArmorItem.Type.BOOTS] = 3
            map[ArmorItem.Type.LEGGINGS] = 6
            map[ArmorItem.Type.CHESTPLATE] = 8
            map[ArmorItem.Type.HELMET] = 4
        },
        8,
        SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,
        4f,
        0f,
        { Ingredient.ofItems(ModItems.REINFORCED_OBSIDIAN) }
    );

    companion object {
        private val BASE_DURABILITY = Util.make(EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java)) { map ->
            map[ArmorItem.Type.BOOTS] = 13
            map[ArmorItem.Type.LEGGINGS] = 15
            map[ArmorItem.Type.CHESTPLATE] = 16
            map[ArmorItem.Type.HELMET] = 11
        }
    }

    override fun getDurability(type: ArmorItem.Type): Int {
        return BASE_DURABILITY[type]!! * durabilityMultiplier
    }

    override fun getProtection(type: ArmorItem.Type): Int {
        return protectionAmounts[type]!!
    }

    override fun getEnchantability(): Int = enchantability

    override fun getEquipSound(): SoundEvent = equipSound

    override fun getRepairIngredient(): Ingredient = repairIngredientSupplier()

    override fun getName(): String = "${AdvancedCombat.MOD_ID}:$materialName"

    override fun getToughness(): Float = toughness

    override fun getKnockbackResistance(): Float = knockbackResistance

    override fun asString(): String = materialName
}