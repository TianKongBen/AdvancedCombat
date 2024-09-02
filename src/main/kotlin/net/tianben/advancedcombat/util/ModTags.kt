package net.tianben.advancedcombat.util

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import net.tianben.advancedcombat.AdvancedCombat.Companion.MOD_ID

class ModTags {
    val ENCHANTMENT_UPGRADE: TagKey<Item?>? = createTag("enchantment_upgrades")

    private fun createTag(name: String?): TagKey<Item?>? {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name))
    }
}