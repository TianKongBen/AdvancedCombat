package net.tianben.advancedcombat.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.tianben.advancedcombat.block.ModBlocks

class ModLootTableProvider(dataOutput: FabricDataOutput) : FabricBlockLootTableProvider(dataOutput) {
    override fun generate() {
        addDrop(ModBlocks.ADVANCED_STONE)
        addDrop(ModBlocks.NETHER_STAR_BLOCK)
    }
}