package net.tianben.advancedcombat

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.tianben.advancedcombat.datagen.ModItemTagProvider
import net.tianben.advancedcombat.datagen.ModLootTableProvider
import net.tianben.advancedcombat.datagen.ModModelProvider
import net.tianben.advancedcombat.datagen.ModRecipeProvider

class AdvancedCombatDataGenerator : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val pack = fabricDataGenerator.createPack()

        pack.addProvider(::ModItemTagProvider)
        pack.addProvider(::ModLootTableProvider)
        pack.addProvider(::ModModelProvider)
        pack.addProvider(::ModRecipeProvider)
    }
}