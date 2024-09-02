package net.tianben.advancedcombat.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.tianben.advancedcombat.AdvancedCombat;

public class ModBlocks {
    public static final Block ADVANCED_STONE = registerBlock("advanced_stone",
            new Block(FabricBlockSettings.create().mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM).requiresTool().strength(3f, 10f)));
    public static final Block NETHER_STAR_BLOCK = registerBlock("nether_star_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.LAPIS_BLUE).requiresTool().strength(6f, 50f)));
    public static final Block NETHER_FORTRESS_BLOCK  = registerBlock("nether_fortress_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.DARK_RED).instrument(Instrument.BASEDRUM).requiresTool().strength(5f, 50f).sounds(BlockSoundGroup.NETHER_BRICKS)));
    public static final Block REINFORCED_OBSIDIAN = registerBlock("reinforced_obsidian",
            new Block(FabricBlockSettings.create().mapColor(MapColor.BLACK).instrument(Instrument.BASEDRUM).requiresTool().strength(50f, 15000f)));
    public static final Block TRACKING_DISPENSER = registerBlock("tracking_dispenser",
            new TrackingDispenser(FabricBlockSettings.copyOf(Blocks.DISPENSER)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(AdvancedCombat.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(AdvancedCombat.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        AdvancedCombat.LOGGER.info("Registering ModBlocks for " + AdvancedCombat.MOD_ID);
    }
}
