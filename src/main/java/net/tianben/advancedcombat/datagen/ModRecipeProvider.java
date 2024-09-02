package net.tianben.advancedcombat.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.tianben.advancedcombat.block.ModBlocks;
import net.tianben.advancedcombat.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADVANCED_WOODEN_SWORD, 1)
                .pattern("LLL")
                .pattern("LWL")
                .pattern("LLL")
                .input('L', ItemTags.LOGS)
                .input('W', Items.WOODEN_SWORD)
                .criterion(hasItem(Items.WOODEN_SWORD), conditionsFromItem(Items.WOODEN_SWORD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADVANCED_WOODEN_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ADVANCED_STONE, 1)
                .pattern("CSC")
                .pattern("SCS")
                .pattern("CSC")
                .input('C', Items.COBBLESTONE)
                .input('S', Items.STONE)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ADVANCED_STONE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADVANCED_STONE_SWORD, 1)
                .pattern("AAA")
                .pattern("ASA")
                .pattern("AAA")
                .input('A', ModBlocks.ADVANCED_STONE)
                .input('S', Items.STONE_SWORD)
                .criterion(hasItem(ModBlocks.ADVANCED_STONE), conditionsFromItem(ModBlocks.ADVANCED_STONE))
                .criterion(hasItem(Items.STONE_SWORD), conditionsFromItem(Items.STONE_SWORD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADVANCED_STONE_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADVANCED_IRON_SWORD, 1)
                .pattern("III")
                .pattern("ISI")
                .pattern("III")
                .input('I', Items.IRON_BLOCK)
                .input('S', Items.IRON_SWORD)
                .criterion(hasItem(Items.IRON_SWORD), conditionsFromItem(Items.IRON_SWORD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADVANCED_IRON_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADVANCED_GOLDEN_SWORD, 1)
                .pattern("GGG")
                .pattern("GSG")
                .pattern("GGG")
                .input('G', Items.GOLD_BLOCK)
                .input('S', Items.GOLDEN_SWORD)
                .criterion(hasItem(Items.GOLDEN_SWORD), conditionsFromItem(Items.GOLDEN_SWORD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADVANCED_GOLDEN_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADVANCED_EMERALD_SWORD, 1)
                .pattern("EEE")
                .pattern("ESE")
                .pattern("EEE")
                .input('E', Items.EMERALD_BLOCK)
                .input('S', Items.GOLDEN_SWORD)
                .criterion(hasItem(Items.GOLDEN_SWORD), conditionsFromItem(Items.GOLDEN_SWORD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADVANCED_EMERALD_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADVANCED_DIAMOND_SWORD, 1)
                .pattern("DDD")
                .pattern("DSD")
                .pattern("DDD")
                .input('D', Items.DIAMOND_BLOCK)
                .input('S', Items.DIAMOND_SWORD)
                .criterion(hasItem(Items.DIAMOND_SWORD), conditionsFromItem(Items.DIAMOND_SWORD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADVANCED_DIAMOND_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHER_STAR_SWORD, 1)
                .pattern("N")
                .pattern("N")
                .pattern("S")
                .input('N', Items.NETHER_STAR)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.NETHER_STAR_SWORD)));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, Items.NETHER_STAR, RecipeCategory.DECORATIONS,
                ModBlocks.NETHER_STAR_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADVANCED_NETHER_STAR_SWORD, 1)
                .pattern(" B ")
                .pattern("ESE")
                .pattern(" N ")
                .input('B', Items.BEACON)
                .input('E', Items.ENCHANTED_GOLDEN_APPLE)
                .input('S', ModItems.NETHER_STAR_SWORD)
                .input('N', ModBlocks.NETHER_STAR_BLOCK)
                .criterion(hasItem(Items.BEACON), conditionsFromItem(Items.BEACON))
                .criterion(hasItem(Items.ENCHANTED_GOLDEN_APPLE), conditionsFromItem(Items.ENCHANTED_GOLDEN_APPLE))
                .criterion(hasItem(ModItems.NETHER_STAR_SWORD), conditionsFromItem(ModItems.NETHER_STAR_SWORD))
                .criterion(hasItem(ModBlocks.NETHER_STAR_BLOCK), conditionsFromItem(ModBlocks.NETHER_STAR_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADVANCED_NETHER_STAR_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADVANCED_BOW, 1)
                .pattern("LIL")
                .pattern("LBL")
                .pattern("LIL")
                .input('L', ItemTags.LOGS)
                .input('I', Items.IRON_BLOCK)
                .input('B', Items.BOW)
                .criterion(hasItem(Items.BOW), conditionsFromItem(Items.BOW))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADVANCED_BOW)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ADVANCED_SHIELD, 1)
                .pattern("LIL")
                .pattern("LSL")
                .pattern("LIL")
                .input('L', ItemTags.LOGS)
                .input('I', Items.IRON_BLOCK)
                .input('S', Items.SHIELD)
                .criterion(hasItem(Items.SHIELD), conditionsFromItem(Items.SHIELD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ADVANCED_SHIELD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.NETHER_FORTRESS_BLOCK, 1)
                .pattern("NIN")
                .pattern("INI")
                .pattern("NIN")
                .input('N', Items.NETHER_BRICKS)
                .input('I', Items.IRON_BARS)
                .criterion(hasItem(Items.NETHER_BRICKS), conditionsFromItem(Items.NETHER_BRICKS))
                .criterion(hasItem(Items.IRON_BARS), conditionsFromItem(Items.IRON_BARS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.NETHER_FORTRESS_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.REINFORCED_OBSIDIAN, 1)
                .pattern("OAO")
                .pattern("AOA")
                .pattern("OAO")
                .input('O', Items.OBSIDIAN)
                .input('A', ModBlocks.ADVANCED_STONE)
                .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                .criterion(hasItem(ModBlocks.ADVANCED_STONE), conditionsFromItem(ModBlocks.ADVANCED_STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.REINFORCED_OBSIDIAN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.TRACKING_DISPENSER, 1)
                .pattern("TCT")
                .pattern("RDR")
                .pattern("TBT")
                .input('T', Items.TRIPWIRE_HOOK)
                .input('C', Items.COMPARATOR)
                .input('R', Items.REDSTONE)
                .input('D', Items.DISPENSER)
                .input('B', Items.REDSTONE_BLOCK)
                .criterion(hasItem(Items.DISPENSER), conditionsFromItem(Items.DISPENSER))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.TRACKING_DISPENSER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SHARPNESS_UPGRADE, 1)
                .pattern("PFP")
                .pattern("FIF")
                .pattern("PFP")
                .input('P', Items.PAPER)
                .input('F', Items.FLINT)
                .input('I', Items.IRON_SWORD)
                .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SHARPNESS_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_SHARPNESS_UPGRADE, 1)
                .pattern("PDP")
                .pattern("DSD")
                .pattern("PDP")
                .input('P', Items.PRISMARINE_SHARD)
                .input('D', Items.DIAMOND_SWORD)
                .input('S', ModItems.SHARPNESS_UPGRADE)
                .criterion(hasItem(ModItems.SHARPNESS_UPGRADE), conditionsFromItem(ModItems.SHARPNESS_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_SHARPNESS_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SMITE_UPGRADE, 1)
                .pattern("PRP")
                .pattern("RBR")
                .pattern("PRP")
                .input('P', Items.PAPER)
                .input('R', Items.ROTTEN_FLESH)
                .input('B', Items.BONE)
                .criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SMITE_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_SMITE_UPGRADE, 1)
                .pattern("SZS")
                .pattern("ZUZ")
                .pattern("SZS")
                .input('S', Items.SKELETON_SKULL)
                .input('Z', Items.ZOMBIE_HEAD)
                .input('U', ModItems.SMITE_UPGRADE)
                .criterion(hasItem(ModItems.SMITE_UPGRADE), conditionsFromItem(ModItems.SMITE_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_SMITE_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SPIDER_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.SPIDER_EYE)
                .input('S', Items.STRING)
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SPIDER_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_SPIDER_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.COBWEB)
                .input('F', Items.FERMENTED_SPIDER_EYE)
                .input('S', ModItems.SPIDER_UPGRADE)
                .criterion(hasItem(ModItems.SPIDER_UPGRADE), conditionsFromItem(ModItems.SPIDER_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_SPIDER_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.KNOCKBACK_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.PISTON)
                .input('S', Items.SLIME_BLOCK)
                .criterion(hasItem(Items.SLIME_BLOCK), conditionsFromItem(Items.SLIME_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.KNOCKBACK_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_KNOCKBACK_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.SLIME_BLOCK)
                .input('F', Items.STICKY_PISTON)
                .input('S', ModItems.KNOCKBACK_UPGRADE)
                .criterion(hasItem(ModItems.KNOCKBACK_UPGRADE), conditionsFromItem(ModItems.KNOCKBACK_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_KNOCKBACK_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FIRE_ASPECT_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.FIRE_CHARGE)
                .input('S', Items.COAL_BLOCK)
                .criterion(hasItem(Items.FIRE_CHARGE), conditionsFromItem(Items.FIRE_CHARGE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FIRE_ASPECT_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_FIRE_ASPECT_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.BLAZE_ROD)
                .input('F', Items.COAL_BLOCK)
                .input('S', ModItems.FIRE_ASPECT_UPGRADE)
                .criterion(hasItem(ModItems.FIRE_ASPECT_UPGRADE), conditionsFromItem(ModItems.FIRE_ASPECT_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_FIRE_ASPECT_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LOOTING_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.GOLD_INGOT)
                .input('S', Items.GOLDEN_SWORD)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LOOTING_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_LOOTING_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.LAPIS_BLOCK)
                .input('F', Items.GOLD_BLOCK)
                .input('S', ModItems.LOOTING_UPGRADE)
                .criterion(hasItem(ModItems.LOOTING_UPGRADE), conditionsFromItem(ModItems.LOOTING_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_LOOTING_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.UNBREAKING_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.OBSIDIAN)
                .input('S', Items.DIAMOND_CHESTPLATE)
                .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.UNBREAKING_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_UNBREAKING_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.DIAMOND_BLOCK)
                .input('F', Items.GHAST_TEAR)
                .input('S', ModItems.UNBREAKING_UPGRADE)
                .criterion(hasItem(ModItems.UNBREAKING_UPGRADE), conditionsFromItem(ModItems.UNBREAKING_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_UNBREAKING_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MENDING_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.ANVIL)
                .input('S', Items.POPPED_CHORUS_FRUIT)
                .criterion(hasItem(Items.ANVIL), conditionsFromItem(Items.ANVIL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.MENDING_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PROTECTION_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.LEATHER_CHESTPLATE)
                .input('S', Items.SHIELD)
                .criterion(hasItem(Items.LEATHER_CHESTPLATE), conditionsFromItem(Items.LEATHER_CHESTPLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PROTECTION_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_PROTECTION_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.OBSIDIAN)
                .input('F', Items.DIAMOND_CHESTPLATE)
                .input('S', ModItems.PROTECTION_UPGRADE)
                .criterion(hasItem(ModItems.PROTECTION_UPGRADE), conditionsFromItem(ModItems.PROTECTION_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_PROTECTION_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FIRE_PROTECTION_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.NETHER_BRICK)
                .input('S', Items.FLINT_AND_STEEL)
                .criterion(hasItem(Items.NETHER_BRICK), conditionsFromItem(Items.NETHER_BRICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FIRE_PROTECTION_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_FIRE_PROTECTION_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.OBSIDIAN)
                .input('F', Items.FIRE_CHARGE)
                .input('S', ModItems.FIRE_PROTECTION_UPGRADE)
                .criterion(hasItem(ModItems.FIRE_PROTECTION_UPGRADE), conditionsFromItem(ModItems.FIRE_PROTECTION_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_FIRE_PROTECTION_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLAST_PROTECTION_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.OBSIDIAN)
                .input('S', Items.TNT)
                .criterion(hasItem(Items.NETHER_BRICK), conditionsFromItem(Items.NETHER_BRICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLAST_PROTECTION_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_BLAST_PROTECTION_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.CREEPER_HEAD)
                .input('F', Items.TNT)
                .input('S', ModItems.BLAST_PROTECTION_UPGRADE)
                .criterion(hasItem(ModItems.BLAST_PROTECTION_UPGRADE), conditionsFromItem(ModItems.BLAST_PROTECTION_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_BLAST_PROTECTION_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PROJECTILE_PROTECTION_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.ARROW)
                .input('S', Items.BOW)
                .criterion(hasItem(Items.ARROW), conditionsFromItem(Items.ARROW))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PROJECTILE_PROTECTION_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_PROJECTILE_PROTECTION_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.OBSIDIAN)
                .input('F', Items.BOW)
                .input('S', ModItems.PROJECTILE_PROTECTION_UPGRADE)
                .criterion(hasItem(ModItems.PROJECTILE_PROTECTION_UPGRADE), conditionsFromItem(ModItems.PROJECTILE_PROTECTION_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_PROJECTILE_PROTECTION_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FEATHER_FALLING_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.FEATHER)
                .input('S', Items.HAY_BLOCK)
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FEATHER_FALLING_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_FEATHER_FALLING_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', ItemTags.BEDS)
                .input('F', Items.HAY_BLOCK)
                .input('S', ModItems.FEATHER_FALLING_UPGRADE)
                .criterion(hasItem(ModItems.FEATHER_FALLING_UPGRADE), conditionsFromItem(ModItems.FEATHER_FALLING_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_FEATHER_FALLING_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RESPIRATION_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.PUFFERFISH)
                .input('S', Items.GLASS_BOTTLE)
                .criterion(hasItem(Items.PUFFERFISH), conditionsFromItem(Items.PUFFERFISH))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RESPIRATION_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AQUA_AFFINITY_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.PUFFERFISH)
                .input('S', Items.IRON_PICKAXE)
                .criterion(hasItem(Items.PUFFERFISH), conditionsFromItem(Items.PUFFERFISH))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.AQUA_AFFINITY_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.THORNS_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.CACTUS)
                .input('S', Items.FLINT)
                .criterion(hasItem(Items.CACTUS), conditionsFromItem(Items.CACTUS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.THORNS_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_THORNS_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.CACTUS)
                .input('F', Items.IRON_BARS)
                .input('S', ModItems.THORNS_UPGRADE)
                .criterion(hasItem(ModItems.THORNS_UPGRADE), conditionsFromItem(ModItems.THORNS_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_THORNS_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DEPTH_STRIDER_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.LEATHER_BOOTS)
                .input('S', Items.WATER_BUCKET)
                .criterion(hasItem(Items.LEATHER_BOOTS), conditionsFromItem(Items.LEATHER_BOOTS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.DEPTH_STRIDER_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FROST_WALKER_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.GOLDEN_BOOTS)
                .input('S', Items.ICE)
                .criterion(hasItem(Items.ICE), conditionsFromItem(Items.ICE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FROST_WALKER_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_FROST_WALKER_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.PACKED_ICE)
                .input('F', Items.DIAMOND_BOOTS)
                .input('S', ModItems.FROST_WALKER_UPGRADE)
                .criterion(hasItem(ModItems.FROST_WALKER_UPGRADE), conditionsFromItem(ModItems.FROST_WALKER_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_FROST_WALKER_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EFFICIENCY_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.REDSTONE)
                .input('S', Items.DIAMOND_PICKAXE)
                .criterion(hasItem(Items.DIAMOND_PICKAXE), conditionsFromItem(Items.DIAMOND_PICKAXE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.EFFICIENCY_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_EFFICIENCY_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.DIAMOND_BLOCK)
                .input('F', Items.REDSTONE_BLOCK)
                .input('S', ModItems.EFFICIENCY_UPGRADE)
                .criterion(hasItem(ModItems.EFFICIENCY_UPGRADE), conditionsFromItem(ModItems.EFFICIENCY_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_EFFICIENCY_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILK_TOUCH_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.STRING)
                .input('S', Items.GOLDEN_PICKAXE)
                .criterion(hasItem(Items.GOLDEN_PICKAXE), conditionsFromItem(Items.GOLDEN_PICKAXE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SILK_TOUCH_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FORTUNE_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.DIAMOND)
                .input('S', Items.GOLD_BLOCK)
                .criterion(hasItem(Items.GOLD_BLOCK), conditionsFromItem(Items.GOLD_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FORTUNE_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_FORTUNE_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.DIAMOND_BLOCK)
                .input('F', Items.GOLD_BLOCK)
                .input('S', ModItems.FORTUNE_UPGRADE)
                .criterion(hasItem(ModItems.FORTUNE_UPGRADE), conditionsFromItem(ModItems.FORTUNE_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_FORTUNE_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POWER_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.ARROW)
                .input('S', Items.FLINT)
                .criterion(hasItem(Items.FLINT), conditionsFromItem(Items.FLINT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.POWER_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_POWER_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.IRON_BLOCK)
                .input('F', Items.ARROW)
                .input('S', ModItems.POWER_UPGRADE)
                .criterion(hasItem(ModItems.POWER_UPGRADE), conditionsFromItem(ModItems.POWER_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_POWER_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PUNCH_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.ARROW)
                .input('S', Items.PISTON)
                .criterion(hasItem(Items.ARROW), conditionsFromItem(Items.ARROW))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.PUNCH_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_PUNCH_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.SLIME_BLOCK)
                .input('F', Items.PISTON)
                .input('S', ModItems.PUNCH_UPGRADE)
                .criterion(hasItem(ModItems.PUNCH_UPGRADE), conditionsFromItem(ModItems.PUNCH_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_PUNCH_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FLAME_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.BLAZE_ROD)
                .input('S', Items.OBSIDIAN)
                .criterion(hasItem(Items.BLAZE_ROD), conditionsFromItem(Items.BLAZE_ROD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FLAME_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INFINITY_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.BOW)
                .input('S', Items.GOLDEN_APPLE)
                .criterion(hasItem(Items.GOLDEN_APPLE), conditionsFromItem(Items.GOLDEN_APPLE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.INFINITY_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LOTS_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.FISHING_ROD)
                .input('S', Items.RABBIT_FOOT)
                .criterion(hasItem(Items.FISHING_ROD), conditionsFromItem(Items.FISHING_ROD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LOTS_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_LOTS_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.EMERALD)
                .input('F', Items.RABBIT_FOOT)
                .input('S', ModItems.LOTS_UPGRADE)
                .criterion(hasItem(ModItems.LOTS_UPGRADE), conditionsFromItem(ModItems.LOTS_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_LOTS_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LURE_UPGRADE, 1)
                .pattern("PEP")
                .pattern("ESE")
                .pattern("PEP")
                .input('P', Items.PAPER)
                .input('E', Items.FISHING_ROD)
                .input('S', Items.COD)
                .criterion(hasItem(Items.FISHING_ROD), conditionsFromItem(Items.FISHING_ROD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LURE_UPGRADE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ELITE_LURE_UPGRADE, 1)
                .pattern("CFC")
                .pattern("FSF")
                .pattern("CFC")
                .input('C', Items.POISONOUS_POTATO)
                .input('F', ItemTags.FISHES)
                .input('S', ModItems.LURE_UPGRADE)
                .criterion(hasItem(ModItems.LURE_UPGRADE), conditionsFromItem(ModItems.LURE_UPGRADE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ELITE_LURE_UPGRADE)));
    }
}
