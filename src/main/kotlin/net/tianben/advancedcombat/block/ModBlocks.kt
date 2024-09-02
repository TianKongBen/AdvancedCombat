package net.tianben.advancedcombat.block

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.MapColor
import net.minecraft.block.enums.Instrument
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.tianben.advancedcombat.AdvancedCombat

object ModBlocks {
    val ADVANCED_STONE: Block = registerBlock("advanced_stone",
        Block(
            FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)
            .requiresTool().strength(3f, 10f)))

    val NETHER_STAR_BLOCK: Block = registerBlock("nether_star_block",
        Block(FabricBlockSettings.create().mapColor(MapColor.LAPIS_BLUE).requiresTool()
            .strength(6f, 50f)))

    val NETHER_FORTRESS_BLOCK: Block = registerBlock("nether_fortress_block",
        Block(FabricBlockSettings.create().mapColor(MapColor.DARK_RED).instrument(Instrument.BASEDRUM)
            .requiresTool().strength(5f, 50f).sounds(BlockSoundGroup.NETHER_BRICKS)))

    val REINFORCED_OBSIDIAN: Block = registerBlock("reinforced_obsidian",
        Block(FabricBlockSettings.create().mapColor(MapColor.BLACK).instrument(Instrument.BASEDRUM)
            .requiresTool().strength(50f, 15000f)))

    val TRACKING_DISPENSER: Block = registerBlock("tracking_dispenser",
        TrackingDispenserBlock(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY)
            .instrument(Instrument.BASEDRUM).requiresTool().strength(3.5f, 12f)))

    private fun registerBlock(name: String, block: Block): Block {
        return Registry.register(Registries.BLOCK, Identifier(AdvancedCombat.MOD_ID, name), block)
    }

    fun registerModBlocks() {
        AdvancedCombat.LOGGER?.info("Registering ModBlocks for ${AdvancedCombat.MOD_ID}")
    }
}