package net.tianben.advancedcombat

import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import net.tianben.advancedcombat.block.ModBlocks
import net.tianben.advancedcombat.item.ModItems
import net.tianben.advancedcombat.item.group.ModItemGroups
import net.tianben.advancedcombat.recipes.ModRecipes
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class AdvancedCombat : ModInitializer {

    companion object {
        const val MOD_ID: String = "advancedcombat"
        val LOGGER: Logger? = LoggerFactory.getLogger(MOD_ID)

        fun ID(path: String): Identifier {
            return Identifier(MOD_ID, path)
        }
    }

    override fun onInitialize() {
        ModItemGroups.registerItemGroups()

        ModBlocks.registerModBlocks()
        ModItems.registerModItems()

        ModRecipes.registerModRecipesSerializers()
    }
}